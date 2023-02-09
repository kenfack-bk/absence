package com.bksoft.absence.features.reports.rest;

import com.bksoft.absence.features.reports.payload.ClassroomReportData;
import com.bksoft.absence.features.reports.payload.StudentReportData;
import com.bksoft.absence.features.reports.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("/api/absence/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    // Get absences informations for a student during a period
    @GetMapping("/student/{registrationNumber}/{startDate}/{endDate}")
    public ResponseEntity<StudentReportData> getStudentAbsenceStat(
            @PathVariable(value = "registrationNumber") String registrationNumber,
            @PathVariable(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){

        System.out.println("Reception de la requête de reporting ...");
        StudentReportData result = reportService.buildStudentStatData(
               registrationNumber, startDate, endDate);
        return new ResponseEntity<>(result,  HttpStatus.OK);
    }

    // Get absences informations for a classroom during a period (day, week, month, semester, accYear, interval)
    @GetMapping("/classroom/{classroomCode}/{startDate}/{endDate}")
    public ResponseEntity<ClassroomReportData> getClassroomAbsenceStat(
            @PathVariable(value = "classroomCode") String classroomCode,
            @PathVariable(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){

        ClassroomReportData result = reportService.buildClassroomStatData(
                classroomCode, startDate, endDate);
        return new ResponseEntity<>(result,  HttpStatus.OK);
    }
}
