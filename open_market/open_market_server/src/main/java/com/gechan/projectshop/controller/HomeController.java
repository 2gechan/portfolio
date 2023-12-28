package com.gechan.projectshop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

    @GetMapping("/main")
    public String home() {
        return "Connection OK";
    }

    @PostMapping("/join")
    public String join() {
        return "OK";
    }
}
