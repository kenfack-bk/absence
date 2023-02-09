package com.bksoft.absence.models;

import java.time.LocalDate;

public class AccYear {

    private String  code;
    private LocalDate startDate;
    private LocalDate endDate;

    public AccYear() {
    }

    public AccYear(String code, LocalDate startDate, LocalDate endDate) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
