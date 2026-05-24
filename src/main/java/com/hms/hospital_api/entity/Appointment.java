package com.hms.hospital_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PATIENT_NAME")
    private String patient;

    @Column(name = "DOCTOR_NAME")
    private String doctor;

    @Column(name = "APPOINTMENT_DATE")
    private String date;

    @Column(name = "APPOINTMENT_TIME")
    private String time;

    public Appointment() {
    }

    public Appointment(
            Integer id,
            String patient,
            String doctor,
            String date,
            String time) {

        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}