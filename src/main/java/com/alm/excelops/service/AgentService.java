package com.alm.excelops.service;

import com.alm.excelops.model.AgentModel;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface AgentService {
    List<AgentModel> saveAgentDetails(XSSFWorkbook workbook);

    void mandatoryFieldCheckInExcel(XSSFWorkbook workbook);
}
