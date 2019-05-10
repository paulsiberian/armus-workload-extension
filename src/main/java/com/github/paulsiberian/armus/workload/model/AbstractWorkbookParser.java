package com.github.paulsiberian.armus.workload.model;

import com.github.paulsiberian.armus.workload.util.WorkbookUtil;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public abstract class AbstractWorkbookParser implements IParser {

    private Workbook workbook;
    private String path;

    public AbstractWorkbookParser() {
    }

    public AbstractWorkbookParser(String path) {
        this.path = path;
    }

    @Override
    public void parse() {
        parse(path);
    }

    @Override
    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void workbookLoad(String path) {
        if (this.path == null) {
            this.path = path;
        }
        workbook = WorkbookUtil.read(path);
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
