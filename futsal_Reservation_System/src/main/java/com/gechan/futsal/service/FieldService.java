package com.gechan.futsal.service;

import java.util.List;

import com.gechan.futsal.models.FieldDto;
import com.gechan.futsal.models.ReservationDto;
import com.gechan.futsal.models.UserDto;

public interface FieldService {

	public int insert(FieldDto filedDto);

	public int delete(long cnumber);

	public List<FieldDto> selectAll();

	public FieldDto findByName(String u_id);

	public int update(FieldDto fieldDto);

	public int fieldReservation(String imageName, UserDto userDto);
	
	public List<ReservationDto> ReservationList(String fieldName);
	
	public int finishMatch(long seq);

}
