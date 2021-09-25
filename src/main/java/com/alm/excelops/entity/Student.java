package com.alm.excelops.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student", schema = "project")
public class Student {

    @Id
    @GeneratedValue(generator = "student_seq")
    @SequenceGenerator(name = "student_seq",schema = "project", sequenceName = "student_seq", initialValue = 1, allocationSize = 1)
    private Long studentId;
    private String name;
    private String pinCode;
    private String city;
    private String state;

}
