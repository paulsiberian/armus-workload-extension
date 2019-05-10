package com.github.paulsiberian.armus.workload.model.errandcard;

import com.github.paulsiberian.armus.workload.util.WorkbookUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ErrandCard {

    private String path;
    private Workbook workbook;
    private Sheet sheet;
    private Cell institute;
    private Cell cathedra;
    private Cell facultyName;
    private Cell academicYear;
    private Cell betAmount;
    private Row[] tableBody;

    public void write() {
        WorkbookUtil.write(workbook, path);
    }

}
