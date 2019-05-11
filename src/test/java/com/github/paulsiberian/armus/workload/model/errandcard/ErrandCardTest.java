package com.github.paulsiberian.armus.workload.model.errandcard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ErrandCardTest {

    private ErrandCard errandCard;

    @BeforeEach
    void setUp() {
        errandCard = new ErrandCard();
    }

    @Test
    void testCreateAndWrite() {
        errandCard.getInstitute().setCellValue("ИТиАС");
        errandCard.getCathedra().setCellValue("АИС");
        errandCard.getFacultyName().setCellValue("Тараборина Е. Н.");
        errandCard.getAcademicYear().setCellValue("2019/2020");
        errandCard.getBetAmount().setCellValue(900);
        errandCard.Write("Тестовая карта поручений");
    }

}