package com.bksoft.absence.models;

import java.time.LocalDate;

public class Semester {

    private int  rank;
    private LocalDate startDate;
    private LocalDate endDate;

    public Semester() {
    }

    public Semester(int rank, LocalDate startDate, LocalDate endDate) {
        this.rank = rank;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
