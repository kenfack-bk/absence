package com.bksoft.absence.payload;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditAbsencePayload {

    private String classroomCode;
    private LocalDate absenceDate;
    private List<AbsenceLine> data;

}
