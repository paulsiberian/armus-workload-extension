package com.github.paulsiberian.armus.workload.model;

import com.github.paulsiberian.armus.database.entitie.Employee;
import com.github.paulsiberian.armus.workload.util.WorkbookLoader;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WLParser implements IParser {

    private Workbook workbook;
    private List<WLSheet> sheetList;
    private String path;

    public WLParser() {
    }

    public WLParser(String path) {
        this.path = path;
    }

    @Override
    public void parse() {
        parse(path);
    }

    @Override
    public void parse(String path) {
        if (this.path == null) {
            this.path = path;
        }
        workbook = WorkbookLoader.load(path);
        sheetList = new ArrayList<>();
        Iterator<Sheet> iterator = workbook.sheetIterator();
        while (iterator.hasNext()) {
            Sheet sheet = iterator.next();
            List<WLDiscipline> disciplines = new ArrayList<>();

            int startCol = 5;

            while (!sheet.getRow(2).getCell(startCol + 1).getStringCellValue().isEmpty()) {
                disciplines.add(new WLDiscipline(sheet, startCol, 16, 56));
                startCol += 3;
            }

            sheetList.add(new WLSheet(sheet.getSheetName(), disciplines));
        }
    }

    @Override
    public void close() {
        try {
            workbook.close();
            sheetList = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<WLDiscipline> getDisciplinesByEducator(String educator) {
        List<WLDiscipline> disciplines = new ArrayList<>();
        for (WLSheet sheet : sheetList) {
            for (WLDiscipline discipline : sheet.getDisciplines()) {
                if (educator.equals(discipline.getEducator())) {
                    disciplines.add(discipline);
                }
            }
        }
        return disciplines;
    }

    public List<WLDiscipline> getDisciplinesByEducator(Employee educator) {
        String name = educator.getSurname() + " " + educator.initials();
        return getDisciplinesByEducator(name);
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public List<WLSheet> getSheetList() {
        return sheetList;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
