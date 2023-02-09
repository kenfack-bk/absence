package com.bksoft.absence.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "slots")
public class Slot extends BaseEntity {

    private int startTime;
    private int endTime;

    private int duration;

    public Slot() {
    }

    public Slot(int startTime, int endTime, int duration) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.duration = duration;
    }

    public int getDuration(){
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}