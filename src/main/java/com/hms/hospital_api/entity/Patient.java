package com.hms.hospital_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PATIENTS")
public class Patient {

    @Id
    private int id;

    private String name;

    private String disease;

    public Patient() {
    }

    public Patient(
            int id,
            String name,
            String disease) {

        this.id = id;
        this.name = name;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name) {

        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(
            String disease) {

        this.disease = disease;
    }
}