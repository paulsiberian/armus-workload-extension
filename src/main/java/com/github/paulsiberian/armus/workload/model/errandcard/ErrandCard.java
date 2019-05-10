package com.github.paulsiberian.armus.workload.model.errandcard;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ErrandCard {

    private Workbook workbook;
    private Sheet sheet;
    private Cell institute;
    private Cell cathedra;
    private Cell facultyName;
    private Cell academicYear;
    private Cell betAmount;
    private Row[] tableBody;

    public ErrandCard() {

        ECTemplate template = new ECTemplate();

        workbook =  template.load();

        sheet = workbook.getSheetAt(0);

        institute = toCell(template.getInstituteCell());
        cathedra = toCell(template.getCathedraCell());
        facultyName = toCell(template.getFacultyNameCell());
        academicYear = toCell(template.getAcademicYearCell());
        betAmount = toCell(template.getBetAmountCell());

        int tableBodySize = template.getTableLastRaw() - template.getTableFirstRaw() + 1;
        tableBody = new Row[tableBodySize];
        for (int i = 0; i < tableBodySize; i++) {
            tableBody[i] = sheet.getRow(i + template.getTableFirstRaw());
        }

    }

    private Cell toCell(CellPosition cell) {
        return sheet.getRow(cell.getI()).getCell(cell.getJ());
    }

    public void Write(String fileName) {
        try(OutputStream file = new FileOutputStream(fileName + ".xlsx")) {
            workbook.write(file);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cell getInstitute() {
        return institute;
    }

    public Cell getCathedra() {
        return cathedra;
    }

    public Cell getFacultyName() {
        return facultyName;
    }

    public Cell getAcademicYear() {
        return academicYear;
    }

    public Cell getBetAmount() {
        return betAmount;
    }

    public Row[] getTableBody() {
        return tableBody;
    }
}
