package com.bksoft.absence.features.reports.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomReportItem {
    private String registrationNumber;
    private String name;
    private int totalAbsences = 0;
    private int totalJustifyAbsences = 0;
}
