package io.github.paulsiberian.armus.workload.model.errandcard;

import io.github.paulsiberian.armus.workload.model.AbstractWorkbookParser;
import io.github.paulsiberian.armus.workload.util.ErrandCardUtil;
import io.github.paulsiberian.armus.workload.util.WorkbookUtil;
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
    private int disciplineTypeCount;

    public ECParser() {
    }

    public ECParser(String path, ECTemplate template) {
        super(path);
        this.template = template;
        disciplineTypeCount = template.getDisciplineTypes().size();
    }

    public ECParser(ECTemplate template) {
        this(template.getPath(), template);
    }

    private double[] readAmountHours(Row row, int columnIndex) {
        double[] amountHours = new double[disciplineTypeCount];
        int j = 0;
        for (int i = columnIndex; j < disciplineTypeCount; i++, j++) {
            amountHours[j] = row.getCell(i).getNumericCellValue();
        }
        return amountHours;
    }

    private void writeValue(Sheet sheet, ECTemplate.Cell tCell, String value) {
        writeValue(sheet, tCell.getRowIndex(), tCell.getColumnIndex(), value);
    }

    private void writeValue(Sheet sheet, ECTemplate.Cell tCell, Double value) {
        writeValue(sheet, tCell.getRowIndex(), tCell.getColumnIndex(), value);
    }

    private void writeValue(Sheet sheet, int row, int col, Double value) {
        sheet
                .getRow(row)
                .getCell(col)
                .setCellValue(value);
    }

    private void writeValue(Sheet sheet, int row, int col, String value) {
        sheet
                .getRow(row)
                .getCell(col)
                .setCellValue(value);
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
        int beginRow = table.getStartRow();

        while (!sheet.getRow(beginRow).getCell(0).getStringCellValue().trim().isEmpty()
                || !sheet.getRow(beginRow).getCell(0).getStringCellValue().trim().equals("Итого:")) {

            Row row = sheet.getRow(beginRow);

            disciplines.add(new ECDiscipline(
                    row.getCell(table.getDisciplineColumn()).getStringCellValue().trim(),
                    row.getCell(table.getAcademicGroupColumn()).getStringCellValue().trim(),
                    (int) row.getCell(table.getStudentsCountColumn()).getNumericCellValue(),
                    readAmountHours(row, table.getFallSemester()),
                    readAmountHours(row, table.getSpringSemester())
            ));

            beginRow++;
        }
    }

    public void save() {
        workbookLoad(getPath());
        Sheet sheet = getWorkbook().getSheetAt(0);

        writeValue(sheet, template.getInstituteCell(), institute);
        writeValue(sheet, template.getCathedraCell(), cathedra);
        writeValue(sheet, template.getEmployeeCell(), educator);
        writeValue(sheet, template.getAcademicYearCell(), academicYear);
        writeValue(sheet, template.getRateAmountCell(), (double) rateAmount);

        ECTemplate.Table table = template.getTable();

        int disciplineCount = disciplines.size();
        int beginRowNum = table.getStartRow();
        int countRows = table.getCountRows();

        ErrandCardUtil.shiftTableRows(sheet, disciplineCount, beginRowNum, countRows, template.getFooterRow());

        for (int i = 0; i < disciplineCount; i++) {
            ECDiscipline discipline = disciplines.get(i);
            Row row = sheet.getRow(i + beginRowNum);
            row.getCell(table.getDisciplineColumn()).setCellValue(discipline.getName());
            row.getCell(table.getAcademicGroupColumn()).setCellValue(discipline.getAcademicGroup());
            row.getCell(table.getStudentsCountColumn()).setCellValue(discipline.getStudentsCount());
            for (int j = 0; j < disciplineTypeCount; j++) {
                row.getCell(j + table.getFallSemester()).setCellValue(discipline.getFallSemesterAmountHours()[j]);
                row.getCell(j + table.getSpringSemester()).setCellValue(discipline.getSpringSemesterAmountHours()[j]);
            }
        }

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
        disciplineTypeCount = template.getDisciplineTypes().size();
    }

}
