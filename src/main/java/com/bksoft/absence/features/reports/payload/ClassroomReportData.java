package com.bksoft.absence.features.reports.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomReportData {

    private String classroomCode;
    private int totalAbsences;
    private int totalJustifyAbsences;

    private List<ClassroomReportItem> details;
}
