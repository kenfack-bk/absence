package com.bksoft.absence.payload;

import java.util.List;

public class AbsenceLine {

    private String studentRegistrationNumber;
    private String studentName;
    private List<Long> slotIds;

    public AbsenceLine() {
    }

    public AbsenceLine(String studentRegistrationNumber, String studentName, List<Long> slotIds) {
        this.studentRegistrationNumber = studentRegistrationNumber;
        this.studentName = studentName;
        this.slotIds = slotIds;
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

    public List<Long> getSlotIds() {
        return slotIds;
    }

    public void setSlotIds(List<Long> slotIds) {
        this.slotIds = slotIds;
    }
}
