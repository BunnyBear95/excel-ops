package com.alm.excelops.service;

import com.alm.excelops.model.AgentModel;
import com.alm.excelops.repository.AgentDAO;
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
public class AgentServiceImpl implements AgentService {

    @Autowired
    AgentDAO agentDAO;

    @Override
    public List<AgentModel> saveAgentDetails(XSSFWorkbook workbook) {
        List<AgentModel> agentModelList = new ArrayList<>();
        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        for (int p = 1; p < sheet.getPhysicalNumberOfRows(); p++) {
            row = sheet.getRow(p);

            if (!isRowEmpty(row)) {
                AgentModel agentModel = new AgentModel();
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    cell = row.getCell(i);
                    cell.setCellType(CellType.STRING);
                    if (cell.getColumnIndex() == 0)
                        agentModel.setRow(cell.getStringCellValue());
                    if (cell.getColumnIndex() == 1)
                        agentModel.setLegalFirstName(cell.getStringCellValue());
                    else if (cell.getColumnIndex() == 2)
                        agentModel.setLegalLastName(cell.getStringCellValue());
                    else if (cell.getColumnIndex() == 3)
                        agentModel.setLegalMiddleName(cell.getStringCellValue());
                    else if (cell.getColumnIndex() == 4)
                        agentModel.setPinCode(cell.getStringCellValue());
                    else if (cell.getColumnIndex() == 5)
                        agentModel.setCity(cell.getStringCellValue());
                    else if (cell.getColumnIndex() == 6)
                        agentModel.setState(cell.getStringCellValue());

                }
                agentModelList.add(agentModel);
            }

        }
        agentDAO.saveAgents(agentModelList);
        return agentModelList;
    }

    @Override
    public void mandatoryFieldCheckInExcel(XSSFWorkbook workbook) {

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
