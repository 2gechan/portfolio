package com.gechan.futsal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gechan.futsal.models.ReservationDto;

public interface ReservationDao {
	
	public int insert(@Param("r_fname") String f_name, @Param("r_uteam") String u_team, @Param("r_uname") String u_name);
	
	public int delete(long seq);

	public List<ReservationDto> reservationList(String r_fname);
	
	public List<ReservationDto> selectAll();
}
