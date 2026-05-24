package com.hms.hospital_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.hospital_api.entity.Appointment;

public interface AppointmentRepository
        extends JpaRepository<Appointment, Integer> {

}