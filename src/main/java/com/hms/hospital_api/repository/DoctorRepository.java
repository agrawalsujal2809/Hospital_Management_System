package com.hms.hospital_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.hospital_api.entity.Doctor;

public interface DoctorRepository
        extends JpaRepository<Doctor, Integer> {

}