package com.hms.hospital_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/appointments/{id}")
    public Appointment getAppointmentById(
            @PathVariable int id) {

        return appointmentRepository.findById(id)
                .orElse(null);
    }

    @PostMapping("/appointments")
    public Appointment addAppointment(
            @RequestBody Appointment appointment) {

        return appointmentRepository.save(appointment);
    }

    @PutMapping("/appointments/{id}")
    public Appointment updateAppointment(
            @PathVariable int id,
            @RequestBody Appointment updatedAppointment) {

        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow();

        appointment.setPatient(
                updatedAppointment.getPatient());

        appointment.setDoctor(
                updatedAppointment.getDoctor());

        appointment.setDate(
                updatedAppointment.getDate());

        appointment.setTime(
                updatedAppointment.getTime());

        return appointmentRepository.save(
                appointment);
    }

    @DeleteMapping("/appointments/{id}")
    public String deleteAppointment(
            @PathVariable int id) {

        appointmentRepository.deleteById(id);

        return "Appointment Deleted Successfully";
    }
}