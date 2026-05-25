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

import com.hms.hospital_api.entity.Bill;
import com.hms.hospital_api.repository.BillRepository;

@RestController
@CrossOrigin(origins = "*")
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @GetMapping("/bills")
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Integer id) {
        return billRepository.findById(id).orElse(null);
    }

    @PostMapping("/bills")
    public Bill addBill(@RequestBody Bill bill) {
        return billRepository.save(bill);
    }

    @PutMapping("/bills/{id}")
    public Bill updateBill(
            @PathVariable Integer id,
            @RequestBody Bill updatedBill) {

        Bill bill =
                billRepository.findById(id).orElse(null);

        if (bill != null) {

            return billRepository.save(updatedBill);
        }

        return null;
    }

    @DeleteMapping("/bills/{id}")
    public String deleteBill(@PathVariable Integer id) {

        billRepository.deleteById(id);

        return "Bill Deleted Successfully";
    }
}