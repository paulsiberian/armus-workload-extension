package com.github.paulsiberian.armus.workload.model.errandcard;

import com.github.paulsiberian.armus.workload.util.WorkbookLoader;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class ECTemplate {

    private final String FILE_NAME = "/resources/errandcard_template/template";
    private CellPosition instituteCell;
    private CellPosition cathedraCell;
    private CellPosition facultyNameCell;
    private CellPosition academicYearCell;
    private CellPosition betAmountCell;
    private int tableFirstRaw;
    private int tableLastRaw;
    private int disciplineNameColumn;
    private int academicGroupsColumn;
    private int studentsCountColumn;
    private int fallSemesterColumn;
    private int springSemesterColumn;
    private int[] lessonsTypeOrder;
    private ClassLoader loader;

    public ECTemplate() {

        Properties properties = new Properties();
        loader = getClass().getClassLoader();

        try(InputStream file = new FileInputStream(
                Objects.requireNonNull(loader.getResource(FILE_NAME + ".xml")).getPath()
        )) {

            properties.loadFromXML(file);
            init(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CellPosition toTCell(String value) {
        String[] tmp = value.split(" ");
        return new CellPosition(
                Integer.parseInt(tmp[0]),
                Integer.parseInt(tmp[1])
        );
    }

    private void init(Properties p) {
        instituteCell = toTCell(p.getProperty("institute_cell"));
        cathedraCell = toTCell(p.getProperty("cathedra_cell"));
        facultyNameCell = toTCell(p.getProperty("faculty_name_cell"));
        academicYearCell = toTCell(p.getProperty("academic_year_cell"));
        betAmountCell = toTCell(p.getProperty("bet_amount_cell"));
        tableFirstRaw = Integer.parseInt(p.getProperty("table_first_raw"));
        tableLastRaw = Integer.parseInt(p.getProperty("table_last_raw"));
        disciplineNameColumn = Integer.parseInt(p.getProperty("discipline_name_column"));
        academicGroupsColumn = Integer.parseInt(p.getProperty("academic_groups_column"));
        studentsCountColumn = Integer.parseInt(p.getProperty("students_count_column"));
        fallSemesterColumn = Integer.parseInt(p.getProperty("fall_semester_column"));
        springSemesterColumn = Integer.parseInt(p.getProperty("spring_semester_column"));
        String tmp = p.getProperty("lessons_type_order");
    }

    public Workbook load() {
        return WorkbookLoader.load(Objects.requireNonNull(loader.getResource(FILE_NAME + ".xlsx")).getPath());
    }

    public CellPosition getInstituteCell() {
        return instituteCell;
    }

    public CellPosition getCathedraCell() {
        return cathedraCell;
    }

    public CellPosition getFacultyNameCell() {
        return facultyNameCell;
    }

    public CellPosition getAcademicYearCell() {
        return academicYearCell;
    }

    public CellPosition getBetAmountCell() {
        return betAmountCell;
    }

    public int getTableFirstRaw() {
        return tableFirstRaw;
    }

    public int getTableLastRaw() {
        return tableLastRaw;
    }

    public int getDisciplineNameColumn() {
        return disciplineNameColumn;
    }

    public int getAcademicGroupsColumn() {
        return academicGroupsColumn;
    }

    public int getStudentsCountColumn() {
        return studentsCountColumn;
    }

    public int getFallSemesterColumn() {
        return fallSemesterColumn;
    }

    public int getSpringSemesterColumn() {
        return springSemesterColumn;
    }

    public int[] getLessonsTypeOrder() {
        return lessonsTypeOrder;
    }
}
