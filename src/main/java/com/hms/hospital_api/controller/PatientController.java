package com.hms.hospital_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.hospital_api.entity.Patient;
import com.hms.hospital_api.repository.PatientRepository;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    @PostMapping("/patients")
    public Patient addPatient(
            @RequestBody Patient patient) {

        return patientRepository.save(patient);
    }
}