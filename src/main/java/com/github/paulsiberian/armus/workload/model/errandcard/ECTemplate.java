package com.github.paulsiberian.armus.workload.model.errandcard;

public class ECTemplate {

    private Cell instituteCell;
    private Cell cathedraCell;
    private Cell employeeCell;
    private Cell academicYearCell;
    private Cell rateAmountCell;
    private Table table;

    public ECTemplate() {
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

    public class Cell {

        private int rowIndex;
        private int columnIndex;

        public Cell() {
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

    public class Table {

        private int beginRow;
        private int endRow;
        private int disciplineColumn;
        private int academicGroupColumn;
        private int studentsCountColumn;
        private Semester fallSemester;
        private Semester springSemester;

        public Table(int beginRow, int endRow) {
            this.beginRow = beginRow;
            this.endRow = endRow;
        }

        public int getBeginRow() {
            return beginRow;
        }

        public int getEndRow() {
            return endRow;
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

        public Semester getFallSemester() {
            return fallSemester;
        }

        public Semester getSpringSemester() {
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

        public Table setFallSemester(Semester fallSemester) {
            this.fallSemester = fallSemester;
            return this;
        }

        public Table setSpringSemester(Semester springSemester) {
            this.springSemester = springSemester;
            return this;
        }
    }

    public class Semester {

        public static final int DISCIPLINE_TYPE_COUNT = 13;
        private int columnIndex;
        private int lecturesColumn;
        private int practicalLessonsColumn;
        private int laboratoryWorksColumn;
        private int selfControlledWorkColumn;
        private int consultationsColumn;
        private int scoresColumn;
        private int examsColumn;
        private int courseWorkColumn;
        private int practiceColumn;
        private int finalQualifyingWorkColumn;
        private int stateExaminationCommisionColumn;
        private int guidanceMasterStudentsColumn;
        private int visitingLessonsColumn;

        public Semester(int columnIndex) {
            this.columnIndex = columnIndex;
        }

        public int getColumnIndex() {
            return columnIndex;
        }

        public int getLecturesColumn() {
            return lecturesColumn;
        }

        public int getPracticalLessonsColumn() {
            return practicalLessonsColumn;
        }

        public int getLaboratoryWorksColumn() {
            return laboratoryWorksColumn;
        }

        public int getSelfControlledWorkColumn() {
            return selfControlledWorkColumn;
        }

        public int getConsultationsColumn() {
            return consultationsColumn;
        }

        public int getScoresColumn() {
            return scoresColumn;
        }

        public int getExamsColumn() {
            return examsColumn;
        }

        public int getCourseWorkColumn() {
            return courseWorkColumn;
        }

        public int getPracticeColumn() {
            return practiceColumn;
        }

        public int getFinalQualifyingWorkColumn() {
            return finalQualifyingWorkColumn;
        }

        public int getStateExaminationCommisionColumn() {
            return stateExaminationCommisionColumn;
        }

        public int getGuidanceMasterStudentsColumn() {
            return guidanceMasterStudentsColumn;
        }

        public int getVisitingLessonsColumn() {
            return visitingLessonsColumn;
        }

        public Semester setLecturesColumn(int lecturesColumn) {
            this.lecturesColumn = lecturesColumn;
            return this;
        }

        public Semester setPracticalLessonsColumn(int practicalLessonsColumn) {
            this.practicalLessonsColumn = practicalLessonsColumn;
            return this;
        }

        public Semester setLaboratoryWorksColumn(int laboratoryWorksColumn) {
            this.laboratoryWorksColumn = laboratoryWorksColumn;
            return this;
        }

        public Semester setSelfControlledWorkColumn(int selfControlledWorkColumn) {
            this.selfControlledWorkColumn = selfControlledWorkColumn;
            return this;
        }

        public Semester setConsultationsColumn(int consultationsColumn) {
            this.consultationsColumn = consultationsColumn;
            return this;
        }

        public Semester setScoresColumn(int scoresColumn) {
            this.scoresColumn = scoresColumn;
            return this;
        }

        public Semester setExamsColumn(int examsColumn) {
            this.examsColumn = examsColumn;
            return this;
        }

        public Semester setCourseWorkColumn(int courseWorkColumn) {
            this.courseWorkColumn = courseWorkColumn;
            return this;
        }

        public Semester setPracticeColumn(int practiceColumn) {
            this.practiceColumn = practiceColumn;
            return this;
        }

        public Semester setFinalQualifyingWorkColumn(int finalQualifyingWorkColumn) {
            this.finalQualifyingWorkColumn = finalQualifyingWorkColumn;
            return this;
        }

        public Semester setStateExaminationCommisionColumn(int stateExaminationCommisionColumn) {
            this.stateExaminationCommisionColumn = stateExaminationCommisionColumn;
            return this;
        }

        public Semester setGuidanceMasterStudentsColumn(int guidanceMasterStudentsColumn) {
            this.guidanceMasterStudentsColumn = guidanceMasterStudentsColumn;
            return this;
        }

        public Semester setVisitingLessonsColumn(int visitingLessonsColumn) {
            this.visitingLessonsColumn = visitingLessonsColumn;
            return this;
        }
    }
}
