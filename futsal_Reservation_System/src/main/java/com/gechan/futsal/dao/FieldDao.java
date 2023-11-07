package com.gechan.futsal.dao;

import java.util.List;

import com.gechan.futsal.models.FieldDto;

public interface FieldDao {
	
	public int insert(FieldDto fieldDto);

	public List<FieldDto> selectAll();
	
	public FieldDto findByName(String u_id);
	
	public int update(FieldDto fieldDto);
	
	public int delete(long cnumber);

	public FieldDto findByImageName(String imageName);
}
