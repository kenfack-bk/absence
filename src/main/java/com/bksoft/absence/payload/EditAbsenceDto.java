package com.bksoft.absence.payload;

import java.time.LocalDate;
import java.util.List;

public class EditAbsenceDto {

    private String classRomCode;
    private LocalDate absenceDate;
    private List<AbsenceLine> absences;

    public EditAbsenceDto() {
    }

    public String getClassRomCode() {
        return classRomCode;
    }

    public void setClassRomCode(String classRomCode) {
        this.classRomCode = classRomCode;
    }

    public LocalDate getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(LocalDate absenceDate) {
        this.absenceDate = absenceDate;
    }

    public List<AbsenceLine> getAbsences() {
        return absences;
    }

    public void setAbsences(List<AbsenceLine> absences) {
        this.absences = absences;
    }
}
