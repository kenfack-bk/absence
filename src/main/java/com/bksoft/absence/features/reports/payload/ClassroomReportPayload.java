package com.bksoft.absence.features.reports.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomReportPayload {

    private String classroomCode;
    private int totalAbsences;
    private int totalJustifyAbsences;
    private List<Item> details;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String registrationNumber;
        private String name;
        private int totalAbsences = 0;
        private int totalJustifyAbsences = 0;
    }

    public static interface IClassroomReportItem {
        public String getRegistrationNumber();
        public String getName();
        public LocalDate getAbsenceDate();
        public boolean isJustify();
        public int getDuration();

        public default void show(){
            System.out.println(getRegistrationNumber() + " : " + getName() + " : " + getAbsenceDate() + " : "
                    + isJustify() + " : " + getDuration());
        }
    }
}
