package com.bksoft.absence.features.reports.payload;

import com.bksoft.absence.models.Absence;
import com.bksoft.absence.models.Slot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReportItem {

    private LocalDate absenceDate;
    private Slot slot;
    private boolean justify;
    private String justification;

    public StudentReportItem(Absence absence){
        this(absence.getAbsenceDate(), absence.getSlot(), absence.isJustify(), absence.getJustification());
    }
}
