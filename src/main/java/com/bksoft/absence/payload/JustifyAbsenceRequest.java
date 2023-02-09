package com.bksoft.absence.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JustifyAbsenceRequest {
    private String registrationNumber;
    private LocalDate absenceDate;
    private String justification;

    private List<Long> slotIds;

}
