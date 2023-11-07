package com.gechan.futsal.service;

import java.util.List;

import com.gechan.futsal.models.UserDto;

public interface UserService {
	
	public int insert(UserDto userDto);
	
	public List<UserDto> selectAll();
	
	public String login(UserDto userDto);
	
	public UserDto findById(String id);

	public String mypage(UserDto userDto);

	public int delete(String id);

	public int update(UserDto userDto);
}
