package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class HomeController {

    @GetMapping("/main")
    public String home() {
        return "Connection OK";
    }

    @GetMapping("/session")
    public UserDto sessionCheck (HttpSession httpSession) {
        UserDto loginUser = (UserDto) httpSession.getAttribute("LOGINUSER");
        return loginUser;
    }
}
