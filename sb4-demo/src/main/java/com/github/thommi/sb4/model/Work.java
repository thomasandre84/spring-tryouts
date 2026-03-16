package com.github.thommi.sb4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Work {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String status;

    protected Work() {
    }

    public Work(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public Work(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
