package com.hms.hospital_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hms.hospital_api.entity.Appointment;
import com.hms.hospital_api.repository.AppointmentRepository;

@RestController
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/appointments/{id}")
    public Appointment getAppointmentById(
            @PathVariable Integer id) {

        return appointmentRepository
                .findById(id)
                .orElse(null);
    }

    @PostMapping("/appointments")
    public Appointment addAppointment(
            @RequestBody Appointment appointment) {

        return appointmentRepository.save(appointment);
    }

    @PutMapping("/appointments/{id}")
    public Appointment updateAppointment(
            @PathVariable Integer id,
            @RequestBody Appointment updatedAppointment) {

        Appointment appointment =
                appointmentRepository
                        .findById(id)
                        .orElse(null);

        if (appointment != null) {

            return appointmentRepository
                    .save(updatedAppointment);
        }

        return null;
    }

    @DeleteMapping("/appointments/{id}")
    public String deleteAppointment(
            @PathVariable Integer id) {

        appointmentRepository.deleteById(id);

        return "Appointment Deleted Successfully";
    }
}