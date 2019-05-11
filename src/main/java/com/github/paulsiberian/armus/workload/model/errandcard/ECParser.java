package com.github.paulsiberian.armus.workload.model.errandcard;

import com.github.paulsiberian.armus.workload.model.AbstractWorkbookParser;
import com.github.paulsiberian.armus.workload.util.WorkbookUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ECParser extends AbstractWorkbookParser {

    private ECTemplate template;
    private String institute;
    private String cathedra;
    private String educator;
    private String academicYear;
    private int rateAmount;
    private List<ECDiscipline> disciplines;

    public ECParser() {
    }

    public ECParser(String path, ECTemplate template) {
        super(path);
        this.template = template;
    }

    private List<Double> readAmountHours(Row row, int columnIndex) {
        List<Double> amountHours = new ArrayList<>();
        for (int i = columnIndex; i < ECTemplate.Semester.DISCIPLINE_TYPE_COUNT; i++) {
            amountHours.add(row.getCell(i).getNumericCellValue());
        }
        return amountHours;
    }

    @Override
    public void parse(String path) {
        workbookLoad(path);
        Sheet sheet = getWorkbook().getSheetAt(0);

        institute = sheet
                .getRow(template.getInstituteCell().getRowIndex())
                .getCell(template.getInstituteCell().getColumnIndex())
                .getStringCellValue();

        cathedra = sheet
                .getRow(template.getCathedraCell().getRowIndex())
                .getCell(template.getCathedraCell().getColumnIndex())
                .getStringCellValue();

        educator = sheet
                .getRow(template.getEmployeeCell().getRowIndex())
                .getCell(template.getEmployeeCell().getColumnIndex())
                .getStringCellValue();

        academicYear = sheet
                .getRow(template.getAcademicYearCell().getRowIndex())
                .getCell(template.getAcademicYearCell().getColumnIndex())
                .getStringCellValue();

        rateAmount = (int) sheet
                .getRow(template.getRateAmountCell().getRowIndex())
                .getCell(template.getRateAmountCell().getColumnIndex())
                .getNumericCellValue();

        disciplines = new ArrayList<>();
        ECTemplate.Table table = template.getTable();
        int beginRow = table.getBeginRow();

        while (!sheet.getRow(beginRow).getCell(0).getStringCellValue().trim().isEmpty()
                || !sheet.getRow(beginRow).getCell(0).getStringCellValue().trim().equals("Итого:")) {

            Row row = sheet.getRow(beginRow);

            disciplines.add(new ECDiscipline(
                    row.getCell(table.getDisciplineColumn()).getStringCellValue().trim(),
                    row.getCell(table.getAcademicGroupColumn()).getStringCellValue().trim(),
                    (int) row.getCell(table.getStudentsCountColumn()).getNumericCellValue(),
                    readAmountHours(row, table.getFallSemester().getColumnIndex()),
                    readAmountHours(row, table.getSpringSemester().getColumnIndex())
            ));

            beginRow++;

        }

    }

    public void save() {
        workbookLoad(getPath());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = dateFormat.format(new Date());
        WorkbookUtil.write(getWorkbook(), educator + " от " + currentDate + ".xlsx");
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getCathedra() {
        return cathedra;
    }

    public void setCathedra(String cathedra) {
        this.cathedra = cathedra;
    }

    public String getEducator() {
        return educator;
    }

    public void setEducator(String educator) {
        this.educator = educator;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public int getRateAmount() {
        return rateAmount;
    }

    public void setRateAmount(int rateAmount) {
        this.rateAmount = rateAmount;
    }

    public List<ECDiscipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<ECDiscipline> disciplines) {
        this.disciplines = disciplines;
    }

    public ECTemplate getTemplate() {
        return template;
    }

    public void setTemplate(ECTemplate template) {
        this.template = template;
    }

}
