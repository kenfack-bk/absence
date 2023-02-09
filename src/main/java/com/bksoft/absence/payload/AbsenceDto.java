package com.bksoft.absence.payload;

import java.time.LocalDate;
import java.util.List;

public class AbsenceDto {

    private LocalDate absenceDate;
    private boolean justify = false;
    private String justification;
    private String studentRegistrationNumber;
    private String studentName;
    private String classRoomCode;
    private List<Integer> slotIds;



    public AbsenceDto() {
    }

    public AbsenceDto(LocalDate absenceDate, boolean justify, String justification, String studentRegistrationNumber,
                      String studentName, String classRoomCode, List<Integer> slotIds) {
        this.absenceDate = absenceDate;
        this.justify = justify;
        this.justification = justification;
        this.studentRegistrationNumber = studentRegistrationNumber;
        this.studentName = studentName;
        this.classRoomCode = classRoomCode;
        this.slotIds = slotIds;
    }

    public LocalDate getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(LocalDate absenceDate) {
        this.absenceDate = absenceDate;
    }

    public boolean isJustify() {
        return justify;
    }

    public void setJustify(boolean justify) {
        this.justify = justify;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getClassRoomCode() {
        return classRoomCode;
    }

    public void setClassRoomCode(String classRoomCode) {
        this.classRoomCode = classRoomCode;
    }

    public String getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public void setStudentRegistrationNumber(String studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Integer> getSlotIds() {
        return slotIds;
    }

    public void setSlotIds(List<Integer> slotIds) {
        this.slotIds = slotIds;
    }
}
