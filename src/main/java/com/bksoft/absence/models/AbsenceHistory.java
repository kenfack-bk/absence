package com.bksoft.absence.models;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "absence_histories")
public class AbsenceHistory extends BaseEntity{

    private LocalDate absenceDate;
    private boolean justify = false;
    private String justification;

    private String studentRegistrationNumber;
    private String classroomCode;
    private String accYear;

    @OneToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    public AbsenceHistory() {
    }

    public AbsenceHistory(LocalDate absenceDate, boolean justify, String justification,
                          String studentRegistrationNumber,
                          String classRoomCode, String accYear, Slot slot) {
        this.absenceDate = absenceDate;
        this.justify = justify;
        this.justification = justification;
        this.studentRegistrationNumber = studentRegistrationNumber;
        this.classroomCode = classRoomCode;
        this.accYear = accYear;
        this.slot = slot;
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

    public String getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public void setStudentRegistrationNumber(String studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public String getClassRoomCode() {
        return classroomCode;
    }

    public void setClassRoomCode(String classRoomCode) {
        this.classroomCode = classRoomCode;
    }

    public String getAccYear() {
        return accYear;
    }

    public void setAccYear(String accYear) {
        this.accYear = accYear;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
