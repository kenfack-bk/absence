package com.bksoft.absence.features.reports.payload;

import java.time.LocalDate;

public interface IClassroomReportItem {

    public String getRegistrationNumber();
    public String getName();
    public LocalDate getAbsenceDate();
    public boolean isJustify();
    public int getDuration();

    public default void show(){
        System.out.println(getRegistrationNumber() + " : " + getName() + " : " + getAbsenceDate() + " : " + isJustify() + " : " + getDuration());
    }
}
