package com.bksoft.absence.features.reports.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentReportData {

    private int totalAbsences;
    private int totalJustifyAbsences;
    private String registrationNumber;
    private String name;

    private List<StudentReportItem> absences;

}
