package com.hms.hospital_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.hospital_api.entity.Patient;
import com.hms.hospital_api.repository.PatientRepository;

@RestController
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return patientRepository.findById(id).orElse(null);
    }

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @PutMapping("/patients/{id}")
    public Patient updatePatient(
            @PathVariable Integer id,
            @RequestBody Patient updatedPatient) {

        Patient patient =
                patientRepository.findById(id).orElse(null);

        if (patient != null) {
            patient.setName(updatedPatient.getName());
            patient.setDisease(updatedPatient.getDisease());

            return patientRepository.save(patient);
        }

        return null;
    }

    @DeleteMapping("/patients/{id}")
    public String deletePatient(@PathVariable Integer id) {

        patientRepository.deleteById(id);

        return "Patient Deleted Successfully";
    }
}