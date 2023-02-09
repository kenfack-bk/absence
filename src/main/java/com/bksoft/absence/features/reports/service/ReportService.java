package com.bksoft.absence.features.reports.service;

import com.bksoft.absence.features.reports.payload.ClassroomReportData;
import com.bksoft.absence.features.reports.payload.StudentReportData;

import java.time.LocalDate;

public interface ReportService {
    StudentReportData buildStudentStatData(String registrationNumber, LocalDate startDate, LocalDate endDate);

    ClassroomReportData buildClassroomStatData(String classroomCode, LocalDate startDate, LocalDate endDate);
}
