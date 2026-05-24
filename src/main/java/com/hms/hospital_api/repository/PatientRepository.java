package com.hms.hospital_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.hospital_api.entity.Patient;

public interface PatientRepository
        extends JpaRepository<Patient, Integer> {

}