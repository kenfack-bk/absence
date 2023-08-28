package com.bksoft.absence.features.reports.service;

import com.bksoft.absence.features.reports.payload.ClassroomReportPayload;
import com.bksoft.absence.features.reports.payload.StudentReportPayload;

import java.time.LocalDate;

public interface ReportService {
    StudentReportPayload buildStudentStatData(String registrationNumber, LocalDate startDate,
                                              LocalDate endDate);
    ClassroomReportPayload buildClassroomStatData(String classroomCode, LocalDate startDate,
                                                  LocalDate endDate);
}
