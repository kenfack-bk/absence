package com.bksoft.absence.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditAbsenceRequest {

    private String classroomCode;
    private LocalDate absenceDate;

    private List<AbsenceLine> data;

}
