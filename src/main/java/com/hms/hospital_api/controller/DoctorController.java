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

import com.hms.hospital_api.entity.Doctor;
import com.hms.hospital_api.repository.DoctorRepository;

@RestController
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(
            @PathVariable Integer id,
            @RequestBody Doctor updatedDoctor) {

        Doctor doctor =
                doctorRepository.findById(id).orElse(null);

        if (doctor != null) {

            doctor.setName(updatedDoctor.getName());
            doctor.setSpecialization(
                    updatedDoctor.getSpecialization());

            return doctorRepository.save(doctor);
        }

        return null;
    }

    @DeleteMapping("/doctors/{id}")
    public String deleteDoctor(@PathVariable Integer id) {

        doctorRepository.deleteById(id);

        return "Doctor Deleted Successfully";
    }
}