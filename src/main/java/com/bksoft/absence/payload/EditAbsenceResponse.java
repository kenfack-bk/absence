package com.bksoft.absence.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 *  Contain the list of saved absences
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class EditAbsenceResponse {

    String classroomCode;
    LocalDate absenceDate;
    List<AbsenceLine> data;

}
