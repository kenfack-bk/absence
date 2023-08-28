package com.bksoft.absence.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbsencePayload {

    private LocalDate absenceDate;
    private boolean justify = false;
    private String justification;
    private String studentRegistrationNumber;
    private String studentName;
    private String classRoomCode;
    private List<Integer> slotIds;

}
