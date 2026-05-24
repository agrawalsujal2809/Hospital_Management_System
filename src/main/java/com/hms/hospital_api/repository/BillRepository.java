package com.hms.hospital_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.hospital_api.entity.Bill;

public interface BillRepository
        extends JpaRepository<Bill, Integer> {

}