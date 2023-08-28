package com.bksoft.absence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tutors")
public class Tutor extends BaseEntity{

    private String name; // name and surname
    private String email;
    private String address;
    private String phoneNumber1;
    private String phoneNumber2;

    public Tutor() {
    }

    public Tutor(String name, String email, String address, String phoneNumber1, String phoneNumber2) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
    }

}
