package com.alm.excelops.service;

import com.alm.excelops.model.StudentModel;
import com.alm.excelops.repository.StudentDAO;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<StudentModel> saveStudentDetails(XSSFWorkbook workbook) {
        List<StudentModel> studentModelList = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        for (int p = 1; p < sheet.getPhysicalNumberOfRows(); p++) {
            row = sheet.getRow(p);

            if (!isRowEmpty(row)) {
                StudentModel studentModel = new StudentModel();
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    cell = row.getCell(i);
                    cell.setCellType(CellType.STRING);
                    if (cell.getColumnIndex() == 0)
                        studentModel.setName(cell.getStringCellValue());
                    if (cell.getColumnIndex() == 1)
                        studentModel.setCity(cell.getStringCellValue());
                    else if (cell.getColumnIndex() == 2)
                        studentModel.setState(cell.getStringCellValue());
                    else if (cell.getColumnIndex() == 3)
                        studentModel.setPinCode(cell.getStringCellValue());
                }
                studentModelList.add(studentModel);
            }

        }
        studentDAO.saveStudents(studentModelList);
        return studentModelList;
    }

    private static boolean isRowEmpty(Row row) {
        boolean isEmpty = true;
        DataFormatter dataFormatter = new DataFormatter();

        if (row != null) {
            for (Cell cell : row) {
                if (dataFormatter.formatCellValue(cell).trim().length() > 0) {
                    isEmpty = false;
                    break;
                }
            }
        }

        return isEmpty;
    }
}
