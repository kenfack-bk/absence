package com.bksoft.absence.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "slots")
@Getter @Setter
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
}