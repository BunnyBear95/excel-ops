package com.alm.excelops.controller;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class Sample {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/pkarra1/Codebase/references/excelops/src/main/resources/sample.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
        XSSFCell cell ;
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row;
        for (int rowIndex = 0; rowIndex < 1; rowIndex++) {
            row = sheet.getRow(rowIndex);
            for (int cellIndex = 0; cellIndex < 3; cellIndex++) {

                cell = (XSSFCell) row.getCell(cellIndex);
                cell.setCellType(CellType.STRING);
                System.out.println(cell.getStringCellValue());
            }
        }
    }
}
