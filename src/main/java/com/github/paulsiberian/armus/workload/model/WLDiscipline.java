package com.github.paulsiberian.armus.workload.model;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.List;

public class WLDiscipline {

    private int id;
    private String name;
    private String academicGroup;
    private int academicCourse;
    private int semester;
    private int studentsCount;
    private String  educator;
    private List<Double> amountHours;

    public WLDiscipline() {
    }

    public WLDiscipline(Sheet sheet, int startCol, int beginRow, int endRow) {
        init(sheet, startCol, beginRow, endRow);
    }

    public void init(Sheet sheet, int startCol, int beginRow, int endRow) {

        int idCol = startCol;
        int nameCol = startCol + 1;
        int groupCol = startCol + 2;
        int courseCol = startCol + 1;
        int semesterCol = startCol + 2;
        int studentsCol = startCol + 2;
        int educatorCol = startCol + 1;
        int budgetCol = startCol + 1;
        int commercialCol = startCol + 2;

        id = (int) doubleValue(sheet.getRow(1).getCell(idCol));

        name = stringValue(sheet.getRow(2).getCell(nameCol));

        academicGroup = stringValue(sheet.getRow(3).getCell(groupCol));

        academicCourse = (int) doubleValue(sheet.getRow(4).getCell(courseCol));

        String semesterTmp = stringValue(sheet.getRow(4).getCell(semesterCol));
        if (!semesterTmp.isEmpty()) {
            try {
                semester = Integer.parseInt(String.valueOf(semesterTmp.charAt(semesterTmp.length() - 1)));
            } catch (NumberFormatException e) {
                semester = 0;
            }
        } else {
            semester = 0;
        }

        studentsCount = (int) doubleValue(sheet.getRow(5).getCell(studentsCol));

        educator = stringValue(sheet.getRow(59).getCell(educatorCol));

        amountHours = new ArrayList<>();

        for (int i = beginRow; i <= endRow; i++) {
            double b = doubleValue(sheet.getRow(i).getCell(budgetCol));
            double c = doubleValue(sheet.getRow(i).getCell(commercialCol));
            amountHours.add(b + c);
        }
    }

    private String stringValue(Cell cell) {
        try {
            return cell.getStringCellValue().trim();
        } catch (NullPointerException e) {
            return "";
        }
    }

    private double doubleValue(Cell cell) {
        try {
            return cell.getNumericCellValue();
        } catch (IllegalStateException e) {
            String str = cell.getStringCellValue().trim();
            if (!str.isEmpty()) {
                return Double.parseDouble(str);
            } else {
                return 0;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademicGroup() {
        return academicGroup;
    }

    public void setAcademicGroup(String academicGroup) {
        this.academicGroup = academicGroup;
    }

    public int getAcademicCourse() {
        return academicCourse;
    }

    public void setAcademicCourse(int academicCourse) {
        this.academicCourse = academicCourse;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public String getEducator() {
        return educator;
    }

    public void setEducator(String educator) {
        this.educator = educator;
    }

    public List<Double> getAmountHours() {
        return amountHours;
    }

    public void setAmountHours(List<Double> amountHours) {
        this.amountHours = amountHours;
    }

    @Override
    public String toString() {
        return "WLDiscipline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", academicGroup='" + academicGroup + '\'' +
                ", academicCourse=" + academicCourse +
                ", semester=" + semester +
                ", studentsCount=" + studentsCount +
                ", educator='" + educator + '\'' +
                '}';
    }
}
