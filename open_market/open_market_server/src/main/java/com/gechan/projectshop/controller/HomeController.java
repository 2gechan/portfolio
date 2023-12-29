package com.gechan.projectshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class HomeController {

    @GetMapping("/main")
    public String home() {
        return "Connection OK";
    }
}
