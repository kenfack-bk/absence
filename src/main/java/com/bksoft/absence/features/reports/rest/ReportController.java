package com.bksoft.absence.features.reports.rest;

import com.bksoft.absence.features.reports.payload.ClassroomReportPayload;
import com.bksoft.absence.features.reports.payload.StudentReportPayload;
import com.bksoft.absence.features.reports.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/api/absence/report")
public class ReportController {

    ReportService reportService;

    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }
    // Get absences report for a student during a period
    @GetMapping("/student/{registrationNumber}/{startDate}/{endDate}")
    public ResponseEntity<StudentReportPayload> getStudentAbsenceStat(
            @PathVariable(value = "registrationNumber") String registrationNumber,
            @PathVariable(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){

        StudentReportPayload result = reportService.buildStudentStatData(
               registrationNumber, startDate, endDate);
        return new ResponseEntity<>(result,  HttpStatus.OK);
    }

    // Get absences report for a classroom during a period
    @GetMapping("/classroom/{classroomCode}/{startDate}/{endDate}")
    public ResponseEntity<ClassroomReportPayload> getClassroomAbsenceStat(
            @PathVariable(value = "classroomCode") String classroomCode,
            @PathVariable(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate){

        ClassroomReportPayload result = reportService.buildClassroomStatData(
                classroomCode, startDate, endDate);
        return new ResponseEntity<>(result,  HttpStatus.OK);
    }
}
