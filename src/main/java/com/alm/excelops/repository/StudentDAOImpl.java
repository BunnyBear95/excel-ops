package com.alm.excelops.repository;

import com.alm.excelops.entity.Student;
import com.alm.excelops.mapper.StudentMapper;
import com.alm.excelops.model.StudentModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public void saveStudents(List<StudentModel> studentModelList) {
        List<Student> studentList = studentMapper.mapStudentsFromModels(studentModelList);
        studentRepository.saveAll(studentList);
    }
}
