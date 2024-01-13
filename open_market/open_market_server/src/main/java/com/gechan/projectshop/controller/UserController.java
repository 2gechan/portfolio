package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.user.UserDto;
import com.gechan.projectshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/login")
    public UserDto login(@RequestBody UserDto user, HttpSession httpSession) {
        log.debug("로그인 정보 : {}", user.toString());
        user = userService.userLogin(user);
        if (user != null) {
            log.debug("로그인 실제 정보 : {}", user.toString());
            httpSession.setAttribute("LOGINUSER", user);
            return user;
        }
        else return null;
    }
}
