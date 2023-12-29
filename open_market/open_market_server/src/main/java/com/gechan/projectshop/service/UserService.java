package com.gechan.projectshop.service;

import com.gechan.projectshop.models.user.UserDto;

public interface UserService {
    public String userValidate(UserDto user);
    public String userJoinSuccess(UserDto joinUser);
}
