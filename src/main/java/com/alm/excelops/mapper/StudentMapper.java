package com.alm.excelops.mapper;

import com.alm.excelops.entity.Student;
import com.alm.excelops.model.StudentModel;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student mapStudentFromModel(StudentModel studentModel);
    List<Student> mapStudentsFromModels(List<StudentModel> studentModelList);

}
