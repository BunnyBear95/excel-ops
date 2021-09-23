package com.alm.excelops.controller;

import com.alm.excelops.model.AgentModel;
import com.alm.excelops.service.AgentService;
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
public class AgentController {

    @Autowired
    AgentService agentService;

    @PostMapping("/save-agent-details")
    public ResponseEntity<Object> saveAgentDetails(@RequestParam("file") MultipartFile excelFile) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
        List<AgentModel> agents  = agentService.saveAgentDetails(workbook);
        return new ResponseEntity<Object>(agents, HttpStatus.OK);
    }

    @PostMapping("/check-valid-excel")
    public ResponseEntity<Object> mandatoryFieldCheckInExcel(@RequestParam("file") MultipartFile excelFile) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
        agentService.mandatoryFieldCheckInExcel(workbook);
        return new ResponseEntity<Object>("ok", HttpStatus.OK);
    }
}
