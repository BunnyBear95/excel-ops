package com.alm.excelops.model;

import lombok.Data;

@Data
public class StudentModel {
    private Long studentId;
    private String name;
    private String pinCode;
    private String city;
    private String state;
}
