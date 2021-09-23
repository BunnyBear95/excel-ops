package com.alm.excelops.model;

public enum ExcelFieldsEnum {
   FIRSTNAME ("Legal First Name"),
    LASTNAME ("Legal Last Name");

    private final String fieldName;

    ExcelFieldsEnum(String name) {
        this.fieldName = name;
    }

    public String getFieldName() {
        return this.fieldName;
    }
}
