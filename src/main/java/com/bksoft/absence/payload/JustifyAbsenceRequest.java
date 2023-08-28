package com.bksoft.absence.payload;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class JustifyAbsenceRequest {
    private String registrationNumber;
    private LocalDate absenceDate;
    private String justification;

    private List<Long> slotIds;

}
