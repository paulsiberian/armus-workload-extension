package io.github.paulsiberian.armus.workload.model.errandcard;

import io.github.paulsiberian.armus.workload.model.WLDiscipline;
import io.github.paulsiberian.armus.workload.model.WLParser;
import io.github.paulsiberian.armus.workload.util.ErrandCardUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ECParserTest {

    private final String templatePath = "/media/paulsiberian/Storage/Dev/Armus_Project/test_src/template.xlsx";
    private final String workloadPath = "/media/paulsiberian/Storage/Dev/Armus_Project/test_src/Расчет часов 2018-2019_каф.АИС 13.08.18г.xls";
    private ECTemplate template;
    private ECParser ecParser;
    private WLParser wlParser;
    private List<int[]> disciplineTypes;

    @BeforeEach
    void setUp() {

        disciplineTypes = new ArrayList<>();
        disciplineTypes.add(new int[]{17});
        disciplineTypes.add(new int[]{18, 19});
        disciplineTypes.add(new int[]{20});
        disciplineTypes.add(new int[]{28});
        disciplineTypes.add(new int[]{21, 22});
        disciplineTypes.add(new int[]{24});
        disciplineTypes.add(new int[]{23});
        disciplineTypes.add(new int[]{26, 27});
        disciplineTypes.add(new int[]{39});
        disciplineTypes.add(new int[]{41, 42, 43});
        disciplineTypes.add(new int[]{38, 46});
        disciplineTypes.add(new int[]{49, 50});
        disciplineTypes.add(new int[]{51});

        template = new ECTemplate(templatePath)
                .setInstituteCell(new ECTemplate.Cell(2, 3))
                .setCathedraCell(new ECTemplate.Cell(3, 3))
                .setEmployeeCell(new ECTemplate.Cell(2, 27))
                .setAcademicYearCell(new ECTemplate.Cell(3, 27))
                .setRateAmountCell(new ECTemplate.Cell(2, 39))
                .setFooterRow(20)
                .setTable(new ECTemplate.Table(7, 11)
                        .setDisciplineColumn(0)
                        .setAcademicGroupColumn(1)
                        .setStudentsCountColumn(2)
                        .setFallSemester(3)
                        .setSpringSemester(17)
                )
                .setDisciplineTypes(disciplineTypes);

        ecParser = new ECParser(template);
        wlParser = new WLParser(workloadPath);
        wlParser.parse();
    }

    @AfterEach
    void tearDown() {
        wlParser.close();
        ecParser.close();
    }

    @Test
    void save() {
        List<WLDiscipline> wlDisciplines = wlParser.getDisciplinesByEducator("Макаров");
        List<ECDiscipline> ecDisciplines = new ArrayList<>();

        ecParser.setInstitute("ИТиАС");
        ecParser.setCathedra("АИС");
        ecParser.setEducator("Макаров Г. В.");
        ecParser.setAcademicYear("2018/2019");
        ecParser.setRateAmount(600);

        for (WLDiscipline wlDiscipline : wlDisciplines) {
            ECDiscipline ecDiscipline = new ECDiscipline();
            ecDiscipline.setName(wlDiscipline.getName());
            ecDiscipline.setAcademicGroup(wlDiscipline.getAcademicGroup());
            ecDiscipline.setStudentsCount(wlDiscipline.getStudentsCount());
            if (wlDiscipline.getSemester() % 2 != 0) {
                ecDiscipline.setFallSemesterAmountHours(ErrandCardUtil.amountHours(wlDiscipline.getAmountHours(), template));
                ecDiscipline.setSpringSemesterAmountHours(new double[disciplineTypes.size()]);
            } else {
                ecDiscipline.setSpringSemesterAmountHours(ErrandCardUtil.amountHours(wlDiscipline.getAmountHours(), template));
                ecDiscipline.setFallSemesterAmountHours(new double[disciplineTypes.size()]);
            }
            ecDisciplines.add(ecDiscipline);
        }

        System.out.println(ecDisciplines.size());

        ecParser.setDisciplines(ecDisciplines);

        ecParser.save();
    }
}