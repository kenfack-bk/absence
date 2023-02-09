package com.bksoft.absence.models;

import javax.persistence.*;

@Entity
@Table(name = "students" , uniqueConstraints = {
        @UniqueConstraint(columnNames = "registrationNumber"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phoneNumber")})
public class Student extends BaseEntity {
    private String registrationNumber;
    private String name;
    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Student() {
    }

    public Student(String registrationNumber, String name, String email, String phoneNumber) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}

