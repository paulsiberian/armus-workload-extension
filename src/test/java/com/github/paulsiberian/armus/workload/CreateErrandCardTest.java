package com.github.paulsiberian.armus.workload;

import com.github.paulsiberian.armus.workload.model.WLParser;
import com.github.paulsiberian.armus.workload.model.errandcard.ECParser;
import com.github.paulsiberian.armus.workload.model.errandcard.ECTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateErrandCardTest {

    private ECTemplate template;
    private ECParser ecParser;
    private WLParser wlParser;

    @BeforeEach
    void setUp() {
        wlParser = new WLParser();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void createTest() {

    }
}
