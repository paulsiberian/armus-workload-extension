package com.github.paulsiberian.armus.workload.model.errandcard;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ECTemplateParser {

    private ClassLoader loader;
    private String path;
    private Cell instituteCell;
    private Cell cathedraCell;
    private Cell employeeCell;
    private Cell academicYearCell;
    private Cell rateAmountCell;
    private Table table;

    public ECTemplateParser() {

        loader = getClass().getClassLoader();

        try(InputStream file = new FileInputStream(
                Objects.requireNonNull(loader.getResource("ECTemplate.xml")).getPath()
        )) {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            Document document = documentBuilder.parse(file);

            Node template = document.getDocumentElement();

            path = template.getAttributes().getNamedItem("Path").getNodeValue();

            NodeList cells = template.getFirstChild().getChildNodes();
            NodeList table = template.getLastChild().getChildNodes();

            instituteCell = parseCell(cells.item(0).getAttributes());
            cathedraCell = parseCell(cells.item(1).getAttributes());
            employeeCell = parseCell(cells.item(2).getAttributes());
            academicYearCell = parseCell(cells.item(3).getAttributes());
            rateAmountCell = parseCell(cells.item(4).getAttributes());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private Cell parseCell(NamedNodeMap attributes) {
        return new Cell()
                .setRaw(Integer.parseInt(attributes.getNamedItem("Raw").getNodeValue()))
                .setColumn(Integer.parseInt(attributes.getNamedItem("Column").getNodeValue()));
    }

    public class Cell {

        private int raw;
        private int column;

        public int getRaw() {
            return raw;
        }

        public int getColumn() {
            return column;
        }

        public Cell setRaw(int raw) {
            this.raw = raw;
            return this;
        }

        public Cell setColumn(int column) {
            this.column = column;
            return this;
        }
    }

    public class Table {

        private int begin;
        private int end;
        private int disciplineColumn;
        private int academicGroupColumn;
        private int studentsCountColumn;
        private Semester fallSemester;
        private Semester springSemester;

        public int getBegin() {
            return begin;
        }

        public int getEnd() {
            return end;
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

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public void setDisciplineColumn(int disciplineColumn) {
            this.disciplineColumn = disciplineColumn;
        }

        public void setAcademicGroupColumn(int academicGroupColumn) {
            this.academicGroupColumn = academicGroupColumn;
        }

        public void setStudentsCountColumn(int studentsCountColumn) {
            this.studentsCountColumn = studentsCountColumn;
        }

        public void setFallSemester(Semester fallSemester) {
            this.fallSemester = fallSemester;
        }

        public void setSpringSemester(Semester springSemester) {
            this.springSemester = springSemester;
        }
    }

    public class Semester {
        private int column;
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

        public int getColumn() {
            return column;
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

        public void setColumn(int column) {
            this.column = column;
        }

        private void setLecturesColumn(int lecturesColumn) {
            this.lecturesColumn = lecturesColumn;
        }

        public void setPracticalLessonsColumn(int practicalLessonsColumn) {
            this.practicalLessonsColumn = practicalLessonsColumn;
        }

        public void setLaboratoryWorksColumn(int laboratoryWorksColumn) {
            this.laboratoryWorksColumn = laboratoryWorksColumn;
        }

        public void setSelfControlledWorkColumn(int selfControlledWorkColumn) {
            this.selfControlledWorkColumn = selfControlledWorkColumn;
        }

        public void setConsultationsColumn(int consultationsColumn) {
            this.consultationsColumn = consultationsColumn;
        }

        public void setScoresColumn(int scoresColumn) {
            this.scoresColumn = scoresColumn;
        }

        public void setExamsColumn(int examsColumn) {
            this.examsColumn = examsColumn;
        }

        public void setCourseWorkColumn(int courseWorkColumn) {
            this.courseWorkColumn = courseWorkColumn;
        }

        public void setPracticeColumn(int practiceColumn) {
            this.practiceColumn = practiceColumn;
        }

        public void setFinalQualifyingWorkColumn(int finalQualifyingWorkColumn) {
            this.finalQualifyingWorkColumn = finalQualifyingWorkColumn;
        }

        public void setStateExaminationCommisionColumn(int stateExaminationCommisionColumn) {
            this.stateExaminationCommisionColumn = stateExaminationCommisionColumn;
        }

        public void setGuidanceMasterStudentsColumn(int guidanceMasterStudentsColumn) {
            this.guidanceMasterStudentsColumn = guidanceMasterStudentsColumn;
        }

        public void setVisitingLessonsColumn(int visitingLessonsColumn) {
            this.visitingLessonsColumn = visitingLessonsColumn;
        }
    }
}
