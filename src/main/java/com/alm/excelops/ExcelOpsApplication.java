package com.alm.excelops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelOpsApplication{
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ExcelOpsApplication.class);
		app.run(args);

		}
}
