package com.gechan.futsal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gechan.futsal.dao.UserDao;
import com.gechan.futsal.models.UserDto;
import com.gechan.futsal.service.UserService;

@Service
public class UserServiceImplV1 implements UserService {

	protected final UserDao userDao;

	public UserServiceImplV1(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int insert(UserDto userDto) {
		if (userDto.getU_div().equals("일반사용자")) {
			if (userDto.getU_team().equals("") || userDto.getU_team() == null) {
				userDto.setU_team("없음");
			}
		}
		return userDao.insert(userDto);
	}

	@Override
	public List<UserDto> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public String login(UserDto userDto) {
		String id = userDto.getU_id();
		String pwd = userDto.getU_password();
		userDto = userDao.findById(id);
		if (userDto == null) {
			return "ID CHECK PLZ";
		} else if (userDto.getU_password().equals(pwd)) {
			return "OK";
		} else {
			return "PASSWORD CHECK PLZ";
		}
	}

	@Override
	public UserDto findById(String id) {
		UserDto userDto = userDao.findById(id);
		return userDto;
	}

	@Override
	public String mypage(UserDto userDto) {

		if (userDto != null) {

			return "OKSESSION";
		} else {
			return "NOSESSION";
		}
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	@Override
	public int update(UserDto userDto) {
		// TODO Auto-generated method stub
		return userDao.update(userDto);
	}

}
