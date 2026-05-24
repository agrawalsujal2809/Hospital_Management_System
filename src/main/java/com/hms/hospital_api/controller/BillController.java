package com.hms.hospital_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.hospital_api.entity.Bill;
import com.hms.hospital_api.repository.BillRepository;

@RestController
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping("/bills")
    public List<Bill> getAllBills() {

        return billRepository.findAll();
    }

    @PostMapping("/bills")
    public Bill addBill(
            @RequestBody Bill bill) {

        return billRepository.save(bill);
    }
}