package com.github.paulsiberian.armus.workload.util;

import com.github.paulsiberian.armus.workload.model.errandcard.ECTemplate;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ErrandCardUtil {

    public static double[] amountHours(double[] amountHours, ECTemplate template) {

        List<int[]> disciplineTypes = template.getDisciplineTypes();
        int size = disciplineTypes.size();
        double[] result = new double[size];
        int i = 0;
        for (int[] values : disciplineTypes) {
            double sum = 0;
            for (int value : values) {
                sum += amountHours[value - 17];
            }
            result[i] = sum;
            i++;
        }
        return result;
    }

    public static void shiftTableRows(Sheet sheet, int disciplineCount, int beginRowNum, int countRows, int footerRowNum) {
        if (disciplineCount > countRows) {
            int startRow = beginRowNum + countRows;
            int endRow = disciplineCount + beginRowNum;
            int step = disciplineCount - countRows;
            SheetUtil.moveRow(sheet, footerRowNum, footerRowNum + step);
            ErrandCardUtil.moveTotalRow(sheet, startRow, startRow + step, step);
            for (int i = startRow; i < endRow; i++) {
                SheetUtil.copyFormulaRow(sheet, i - 1, i);
            }
        }
    }

    private static Row moveTotalRow(Sheet sheet, int sourceRowNum, int destinationRowNum, int step) {
        Row row = SheetUtil.moveRow(sheet, sourceRowNum, destinationRowNum);
        Iterator<Cell> iterator = row.cellIterator();
        while (iterator.hasNext()) {
            Cell cell = iterator.next();
            if (cell.getCellType().equals(CellType.FORMULA)) {
                String formula = cell.getCellFormula();
                int start = formula.indexOf(':') + 1;
                int end = formula.lastIndexOf(')');
                String endRowName = formula.substring(start, end);
                String endRowStr = endRowName.replaceAll("[^\\D]", "");
                int endRowNum = Integer.parseInt(endRowName.replaceAll("[^\\d]", "")) + step;
                cell.setCellFormula(formula.substring(0, start) + endRowStr + endRowNum + formula.substring(end));
            }
        }
        return row;
    }
}
