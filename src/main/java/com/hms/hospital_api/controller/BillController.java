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

    @GetMapping("/bills/{id}")
    public Bill getBillById(
            @PathVariable int id) {

        return billRepository.findById(id)
                .orElse(null);
    }

    @PostMapping("/bills")
    public Bill addBill(
            @RequestBody Bill bill) {

        return billRepository.save(bill);
    }

    @PutMapping("/bills/{id}")
    public Bill updateBill(
            @PathVariable int id,
            @RequestBody Bill updatedBill) {

        Bill bill =
                billRepository.findById(id)
                        .orElseThrow();

        bill.setPatient(
                updatedBill.getPatient());

        bill.setDays(
                updatedBill.getDays());

        bill.setAmount(
                updatedBill.getAmount());

        return billRepository.save(
                bill);
    }

    @DeleteMapping("/bills/{id}")
    public String deleteBill(
            @PathVariable int id) {

        billRepository.deleteById(id);

        return "Bill Deleted Successfully";
    }
}