package com.alm.excelops.controller;

import org.hibernate.type.LocalDateTimeType;
import org.springframework.format.datetime.DateFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

public class Example {
    public static void main(String[] args) throws ParseException {
        String myDateString = "2021-08-16";
//        DateFormat
        DateTimeFormatter f = DateTimeFormatter.ofPattern(myDateString);
        LocalDate l =  LocalDate.parse(myDateString);
//        DateTimeFormatter f = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        SimpleDateFormat outFormat = new SimpleDateFormat("DD/MM/YYYY");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(myDateString);
        System.out.println(date);
//        System.out.println(f.parse("DD/MM/YYYY"));
//
        System.out.println(outFormat.format(date));
//        System.out.println(l);
//        System.out.println(s);
//        System.out.println(f.format(l));
        LocalDateTime lt = LocalDateTime.parse(date.toString());
        System.out.println(lt);
//        LocalDateTime lt = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String result = outFormat.format(l);
//        System.out.println(result);
}
}
