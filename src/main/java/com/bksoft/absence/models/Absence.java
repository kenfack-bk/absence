package com.bksoft.absence.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
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

}
