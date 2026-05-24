package com.hms.hospital_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.hospital_api.entity.Appointment;
import com.hms.hospital_api.repository.AppointmentRepository;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {

        return appointmentRepository.findAll();
    }

    @PostMapping("/appointments")
    public Appointment addAppointment(
            @RequestBody Appointment appointment) {

        return appointmentRepository.save(appointment);
    }
}