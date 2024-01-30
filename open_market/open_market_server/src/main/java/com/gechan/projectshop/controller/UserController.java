package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.user.UserDto;
import com.gechan.projectshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/logout")
    public void logout(HttpSession httpSession) {
        httpSession.removeAttribute("LOGINUSER");
        log.debug("세션 정보 : {}", httpSession.getAttribute("LOGINUSER"));
    }

    @PostMapping("/sessionChk")
    public UserDto sessionChk (HttpSession httpSession, @RequestBody UserDto userDto) {
        UserDto curruntUser = (UserDto) httpSession.getAttribute("LOGINUSER");
        log.debug("클라이언트 유저 정보 : {}", userDto.toString());
        // log.debug("서버 유저 정보 : {}", curruntUser.toString()); nullPointException
        if (curruntUser == null && userDto.getU_id() != null) {
            curruntUser = userDto;
            httpSession.setAttribute("LOGINUSER", userDto);
        }
        return curruntUser;
    }
}
