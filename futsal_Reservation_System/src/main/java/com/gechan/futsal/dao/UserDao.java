package com.gechan.futsal.dao;

import java.util.List;

import com.gechan.futsal.models.UserDto;

public interface UserDao {
	
	public List<UserDto> selectAll();
	
	public int insert(UserDto userDto);
	
	public UserDto login(UserDto userDto);
	
	public UserDto findById(String id);

	public int delete(String id);

	public int update(UserDto userDto);

}
