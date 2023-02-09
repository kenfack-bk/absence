package com.bksoft.absence.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "absences")
public class Absence extends BaseEntity{

    private LocalDate absenceDate;
    private boolean justify = false;
    private String justification;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Absence() {
    }

    public Absence(LocalDate absenceDate, boolean justify, String justification, Slot slot, Student student, Classroom classroom) {
        this.absenceDate = absenceDate;
        this.justify = justify;
        this.justification = justification;
        this.slot = slot;
        this.student = student;
        this.classroom = classroom;
    }

    public void justify(String justification){
        this.justify = true;
        this.justification = justification;
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

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classroom getClassRoom() {
        return classroom;
    }

    public void setClassRoom(Classroom classRoom) {
        this.classroom = classRoom;
    }
}
