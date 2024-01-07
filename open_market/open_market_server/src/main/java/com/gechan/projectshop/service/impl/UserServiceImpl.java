package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.UserRepository;
import com.gechan.projectshop.models.user.UserDto;
import com.gechan.projectshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String userValidate(UserDto user) {
        UserDto dto = userRepository.findById(user.getU_id()).orElse(null);
        if (dto != null) return "이미 존재하는 아이디 입니다.";
        else return "사용 가능한 아이디 입니다.";
    }

    @Override
    public UserDto userLogin(UserDto loginUser) {
        UserDto dto = userRepository.findById(loginUser.getU_id()).orElse(null);
        if (dto != null && dto.getU_id().equals(loginUser.getU_id())) {
            return dto;
        } else return dto;
    }

    @Override
    public UserDto userJoin(UserDto joinUser) {
        UserDto user = userRepository.save(joinUser);
        return user;
    }
}
