/*
 * Copyright (c) Храпунов П. Н., 2019.
 */

package io.github.paulsiberian.armus.workload.model.errandcard;

import java.util.List;
import java.util.Objects;

public class ECTemplate {

    private String path;
    private Cell instituteCell;
    private Cell cathedraCell;
    private Cell employeeCell;
    private Cell academicYearCell;
    private Cell rateAmountCell;
    private Table table;
    private int footerRow;
    private List<int[]> disciplineTypes;

    public ECTemplate() {
    }

    public ECTemplate(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public ECTemplate setPath(String path) {
        this.path = path;
        return this;
    }

    public Cell getInstituteCell() {
        return instituteCell;
    }

    public ECTemplate setInstituteCell(Cell instituteCell) {
        this.instituteCell = instituteCell;
        return this;
    }

    public Cell getCathedraCell() {
        return cathedraCell;
    }

    public ECTemplate setCathedraCell(Cell cathedraCell) {
        this.cathedraCell = cathedraCell;
        return this;
    }

    public Cell getEmployeeCell() {
        return employeeCell;
    }

    public ECTemplate setEmployeeCell(Cell employeeCell) {
        this.employeeCell = employeeCell;
        return this;
    }

    public Cell getAcademicYearCell() {
        return academicYearCell;
    }

    public ECTemplate setAcademicYearCell(Cell academicYearCell) {
        this.academicYearCell = academicYearCell;
        return this;
    }

    public Cell getRateAmountCell() {
        return rateAmountCell;
    }

    public ECTemplate setRateAmountCell(Cell rateAmountCell) {
        this.rateAmountCell = rateAmountCell;
        return this;
    }

    public Table getTable() {
        return table;
    }

    public ECTemplate setTable(Table table) {
        this.table = table;
        return this;
    }

    public int getFooterRow() {
        return footerRow;
    }

    public ECTemplate setFooterRow(int footerRow) {
        this.footerRow = footerRow;
        return this;
    }

    public List<int[]> getDisciplineTypes() {
        return disciplineTypes;
    }

    public ECTemplate setDisciplineTypes(List<int[]> disciplineTypes) {
        this.disciplineTypes = disciplineTypes;
        return this;
    }

    public static class Cell {

        private int rowIndex;
        private int columnIndex;

        public Cell() {
        }

        public Cell(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public int getColumnIndex() {
            return columnIndex;
        }

        public Cell setRowIndex(int rowIndex) {
            this.rowIndex = rowIndex;
            return this;
        }

        public Cell setColumnIndex(int columnIndex) {
            this.columnIndex = columnIndex;
            return this;
        }
    }

    public static class Table {

        private int startRow;
        private int countRows;
        private int disciplineColumn;
        private int academicGroupColumn;
        private int studentsCountColumn;
        private int fallSemester;
        private int springSemester;

        public Table(int startRow, int countRows) {
            this.startRow = startRow;
            this.countRows = countRows;
        }

        public int getStartRow() {
            return startRow;
        }

        public int getCountRows() {
            return countRows;
        }

        public int getDisciplineColumn() {
            return disciplineColumn;
        }

        public int getAcademicGroupColumn() {
            return academicGroupColumn;
        }

        public int getStudentsCountColumn() {
            return studentsCountColumn;
        }

        public int getFallSemester() {
            return fallSemester;
        }

        public int getSpringSemester() {
            return springSemester;
        }

        public Table setDisciplineColumn(int disciplineColumn) {
            this.disciplineColumn = disciplineColumn;
            return this;
        }

        public Table setAcademicGroupColumn(int academicGroupColumn) {
            this.academicGroupColumn = academicGroupColumn;
            return this;
        }

        public Table setStudentsCountColumn(int studentsCountColumn) {
            this.studentsCountColumn = studentsCountColumn;
            return this;
        }

        public Table setFallSemester(int fallSemester) {
            this.fallSemester = fallSemester;
            return this;
        }

        public Table setSpringSemester(int springSemester) {
            this.springSemester = springSemester;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Table table = (Table) o;
            return startRow == table.startRow &&
                    countRows == table.countRows &&
                    disciplineColumn == table.disciplineColumn &&
                    academicGroupColumn == table.academicGroupColumn &&
                    studentsCountColumn == table.studentsCountColumn &&
                    fallSemester == table.fallSemester &&
                    springSemester == table.springSemester;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startRow, countRows, disciplineColumn, academicGroupColumn, studentsCountColumn, fallSemester, springSemester);
        }
    }
}
