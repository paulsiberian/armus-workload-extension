package com.github.paulsiberian.armus.workload.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class WorkbookLoader {

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    public static Workbook load(String path) {
        String fileExtension = fileExtension(path);
        try(FileInputStream file = new FileInputStream(path)) {
            if (fileExtension.equals(XLS)) {
                POIFSFileSystem fileSystem = new POIFSFileSystem(file);
                return new HSSFWorkbook(fileSystem);
            } else if (fileExtension.equals(XLSX)) {
                return new XSSFWorkbook(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String fileExtension(String path) {
        return path.substring(path.lastIndexOf('.') + 1).toLowerCase();
    }
}
