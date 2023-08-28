package com.bksoft.absence.features.edit.service;

import com.bksoft.absence.models.Student;
import com.bksoft.absence.payload.EditAbsencePayload;
import com.bksoft.absence.payload.JustifyAbsenceRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EditService {

    Map<Student, List<Long>> fetchClassroomAbsences(String code, LocalDate absenceDate);

    /**
     *
     * @param request
     * @return number of correctly absence added
     */
    void editAbsences(EditAbsencePayload request);

    void justifyAbsences(JustifyAbsenceRequest request);

}
