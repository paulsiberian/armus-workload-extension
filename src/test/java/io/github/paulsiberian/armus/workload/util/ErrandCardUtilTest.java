package io.github.paulsiberian.armus.workload.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ErrandCardUtilTest {

    private final int disciplineCount = 21;
    private final int beginRowNum = 7;
    private final int countRows = 11;
    private final int footerRowNum = 20;
    private final String templatePath = "/media/paulsiberian/Storage/Dev/Armus_Project/test_src/template.xlsx";
    private final String outPath = "/media/paulsiberian/Storage/Dev/Armus_Project/test_src/testOutFile.xlsx";
    private Workbook workbook;
    private Sheet sheet;

    @BeforeEach
    void setUp() {
        workbook = WorkbookUtil.read(templatePath);
        sheet = workbook.getSheetAt(0);
    }

    @AfterEach
    void tearDown() {
        WorkbookUtil.write(workbook, outPath);
    }

    @Test
    void amountHours() {
    }

    @Test
    void shiftTableRows() {
        ErrandCardUtil.shiftTableRows(sheet, disciplineCount, beginRowNum, countRows, footerRowNum);
    }
}