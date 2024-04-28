package com.gechan.projectshop.service;

import com.gechan.projectshop.models.user.UserDto;

public interface UserService {
    public String userValidate(UserDto user);
    public UserDto userJoin(UserDto joinUser);
    public UserDto userLogin(UserDto loginUser);
    public UserDto findById(String u_id);
}
