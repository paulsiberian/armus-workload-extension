package io.github.paulsiberian.armus.workload;

import io.github.paulsiberian.armus.workload.model.WLDiscipline;
import io.github.paulsiberian.armus.workload.model.WLParser;
import io.github.paulsiberian.armus.workload.model.WLSheet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class WLParserTest {

    private WLParser parser;
    //    private List<WLDiscipline> disciplines;
    private List<WLSheet> sheets;

    @BeforeEach
    void setUp() {
        parser = new WLParser();
    }

    @AfterEach
    void tearDown() {
        parser.close();
//        for (WLDiscipline d : disciplines) {
//            System.out.println(d);
//        }
        for (WLSheet ss : sheets) {
            if (!ss.getDisciplines().isEmpty()) {
                System.out.println(ss);
                for (WLDiscipline d : ss.getDisciplines()) {
                    if (d.getSemester() == 0) {
                        System.out.println(d);
                    }
                }
            }
        }
    }

    @Test
    void parse() {
        parser.parse("/home/paulsiberian/Расчет часов 2019-2020 каф.АИС.xls");
//        disciplines = parser.getDisciplinesByEducator("Макаров");
        sheets = parser.getSheetList();
    }

}