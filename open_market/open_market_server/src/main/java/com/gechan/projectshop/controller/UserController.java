package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.user.UserDto;
import com.gechan.projectshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/idValidate")
    public String idValidate(@RequestBody UserDto user) {
        log.debug("입력된 아이디 {}", user.getU_id());
        return userService.userValidate(user);
    }

    @PostMapping("/join")
    public UserDto join(@RequestBody UserDto user) {
        log.debug("회원가입 정보 : {}", user.toString());
        return userService.userJoin(user);
    }
}
