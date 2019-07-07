/*
 * Copyright (c) Храпунов П. Н., 2019.
 */

package io.github.paulsiberian.armus.workload.model;

import io.github.paulsiberian.armus.api.database.Employee;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WLParser extends AbstractWorkbookParser {

    private List<WLSheet> sheetList;

    public WLParser() {
    }

    public WLParser(String path) {
        super(path);
    }

    @Override
    public void parse(String path) {
        workbookLoad(path);
        sheetList = new ArrayList<>();
        Iterator<Sheet> iterator = getWorkbook().sheetIterator();
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
        super.close();
        sheetList = null;
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
        String name = educator.getPerson().getSurname() + " " + educator.getPerson().initials();
        return getDisciplinesByEducator(name);
    }

    public List<WLSheet> getSheetList() {
        return sheetList;
    }

}
