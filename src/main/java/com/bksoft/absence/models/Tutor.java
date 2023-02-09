package com.bksoft.absence.models;

import javax.persistence.Entity;
import javax.persistence.Table;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }
}
