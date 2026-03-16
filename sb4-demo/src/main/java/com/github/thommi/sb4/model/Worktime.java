package com.github.thommi.sb4.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
public class Worktime {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private Work work;

    private Instant startTime;
    private Instant endTime;

    protected Worktime() {
    }

    public Worktime(Work work, Instant startTime) {
        this.work = work;
        this.startTime = startTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }
}
