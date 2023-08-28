package com.bksoft.absence.features.reports.payload;

import com.bksoft.absence.models.Absence;
import com.bksoft.absence.models.Slot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentReportPayload {

    private int totalAbsences;
    private int totalJustifyAbsences;
    private String registrationNumber;
    private String name;
    private List<Item> absences;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {

        private LocalDate absenceDate;
        private Slot slot;
        private boolean justify;
        private String justification;

        public Item(Absence absence){
            this(absence.getAbsenceDate(), absence.getSlot(), absence.isJustify(), absence.getJustification());
        }
    }
}
