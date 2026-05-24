package com.hms.hospital_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BILL")
public class Bill {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PATIENT_NAME")
    private String patient;

    @Column(name = "DAYS_ADMITTED")
    private Integer days;

    @Column(name = "FINAL_AMOUNT")
    private Double amount;

    public Bill() {
    }

    public Bill(
            Integer id,
            String patient,
            Integer days,
            Double amount) {

        this.id = id;
        this.patient = patient;
        this.days = days;
        this.amount = amount;
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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}