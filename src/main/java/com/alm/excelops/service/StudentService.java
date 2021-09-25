package com.alm.excelops.service;

import com.alm.excelops.model.StudentModel;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface StudentService {
    List<StudentModel> saveStudentDetails(XSSFWorkbook workbook);

    void mandatoryFieldCheckInExcel(XSSFWorkbook workbook);
}
