package com.github.paulsiberian.armus.workload.util;

import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaRenderer;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;

public class SheetUtil {

    public static String copyFormula(Sheet sheet, String formula, int rowStep, int colStep) {
        XSSFEvaluationWorkbook workbook = XSSFEvaluationWorkbook.create((XSSFWorkbook) sheet.getWorkbook());
        Ptg[] ptgs = FormulaParser.parse(formula, workbook, FormulaType.CELL, sheet.getWorkbook().getSheetIndex(sheet));

        for (Ptg ptg : ptgs) {
            if (ptg instanceof RefPtgBase) {
                RefPtgBase ref = (RefPtgBase) ptg;
                if (ref.isColRelative()) {
                    ref.setColumn(ref.getColumn() + colStep);
                }
                if (ref.isRowRelative()) {
                    ref.setRow(ref.getRow() + rowStep);
                }
            } else if (ptg instanceof AreaPtgBase) {
                AreaPtgBase area = (AreaPtgBase) ptg;
                if (area.isFirstColRelative()) {
                    area.setFirstColumn(area.getFirstColumn() + colStep);
                }
                if (area.isLastColRelative()) {
                    area.setLastColumn(area.getLastColumn() + colStep);
                }
                if (area.isFirstRowRelative()) {
                    area.setFirstRow(area.getFirstRow() + rowStep);
                }
                if (area.isLastRowRelative()) {
                    area.setLastRow(area.getLastRow() + rowStep);
                }
            }
        }

        return FormulaRenderer.toFormulaString(workbook, ptgs);
    }

    public static Row moveFormulaRow(Sheet sheet, int sourceRowNum, int destinationRowNum) {
        Row row = copyFormulaRow(sheet, sourceRowNum, destinationRowNum);
        sheet.removeRow(sheet.getRow(sourceRowNum));
        return row;
    }

    public static Row copyFormulaRow(Sheet sheet, int sourceRowNum, int destinationRowNum) {
        Row row = copyRow(sheet, sourceRowNum, destinationRowNum);
        Iterator<Cell> iterator = row.cellIterator();
        while (iterator.hasNext()) {
            Cell cell = iterator.next();
            if (cell.getCellType().equals(CellType.FORMULA)) {
                String formula = cell.getCellFormula();
                cell.setCellFormula(copyFormula(sheet, formula, destinationRowNum - sourceRowNum, 0));
            }
        }
        return row;
    }

    public static Row moveRow(Sheet sheet, int sourceRowNum, int destinationRowNum) {
        Row row = copyRow(sheet, sourceRowNum, destinationRowNum);
        sheet.removeRow(sheet.getRow(sourceRowNum));
        return row;
    }

    public static Row copyRow(Sheet sheet, int sourceRowNum, int destinationRowNum) {

        Row sourceRow = sheet.getRow(sourceRowNum);
        Row destinationRow = sheet.getRow(destinationRowNum);

        if (destinationRow == null) {
            destinationRow = sheet.createRow(destinationRowNum);
        }

        Iterator<Cell> iterator = sourceRow.cellIterator();

        while (iterator.hasNext()) {
            Cell sourceCell = iterator.next();
            int i = sourceCell.getColumnIndex();
            Cell destinationCell = destinationRow.createCell(i);

            destinationCell.setCellStyle(sourceCell.getCellStyle());

            if (sourceCell.getCellComment() != null) {
                destinationCell.setCellComment(sourceCell.getCellComment());
            }

            if (sourceCell.getHyperlink() != null) {
                destinationCell.setHyperlink(sourceCell.getHyperlink());
            }

            destinationCell.setCellType(sourceCell.getCellType());

            switch (sourceCell.getCellType()) {
                case BLANK:
                    destinationCell.setCellValue(sourceCell.getStringCellValue());
                    break;
                case BOOLEAN:
                    destinationCell.setCellValue(sourceCell.getBooleanCellValue());
                    break;
                case ERROR:
                    destinationCell.setCellErrorValue(sourceCell.getErrorCellValue());
                    break;
                case FORMULA:
                    destinationCell.setCellFormula(sourceCell.getCellFormula());
                    break;
                case NUMERIC:
                    destinationCell.setCellValue(sourceCell.getNumericCellValue());
                    break;
                case STRING:
                    destinationCell.setCellValue(sourceCell.getRichStringCellValue());
                    break;
            }
        }

        return destinationRow;
    }
}
