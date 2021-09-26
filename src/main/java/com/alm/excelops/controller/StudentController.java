package com.alm.excelops.controller;

import com.alm.excelops.model.StudentModel;
import com.alm.excelops.service.StudentService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save-student-details")
    public ResponseEntity<Object> saveStudentDetails(@RequestParam("file") MultipartFile excelFile) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
        List<StudentModel> studentModelList  = studentService.saveStudentDetails(workbook);
        return new ResponseEntity<Object>(studentModelList, HttpStatus.OK);
    }
}
