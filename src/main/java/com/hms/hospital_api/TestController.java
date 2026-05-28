package com.hms.hospital_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Hospital API is running. Use /test, /patients, /doctors, /appointments, or /bills.";
    }

    @GetMapping("/test")
    public String test() {
        return "Hospital API Working";
    }
}