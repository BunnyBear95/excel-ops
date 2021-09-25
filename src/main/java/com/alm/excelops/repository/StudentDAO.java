package com.alm.excelops.repository;

import com.alm.excelops.model.StudentModel;

import java.util.List;

public interface StudentDAO {

    void saveStudents(List<StudentModel> studentModelList);
}
