package com.gechan.futsal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gechan.futsal.dao.FieldDao;
import com.gechan.futsal.dao.ReservationDao;
import com.gechan.futsal.dao.UserDao;
import com.gechan.futsal.models.FieldDto;
import com.gechan.futsal.models.ReservationDto;
import com.gechan.futsal.models.UserDto;
import com.gechan.futsal.service.FieldService;

@Service
public class FieldServiceImplV1 implements FieldService {

	protected final FieldDao fieldDao;
	protected final UserDao userDao;
	protected final ReservationDao reservationDao;

	public FieldServiceImplV1(FieldDao fieldDao, UserDao userDao, ReservationDao reservationDao) {
		this.fieldDao = fieldDao;
		this.userDao = userDao;
		this.reservationDao = reservationDao;
	}

	@Override
	public int insert(FieldDto filedDto) {
		// TODO Auto-generated method stub
		return fieldDao.insert(filedDto);
	}

	@Override
	public int delete(long cnumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FieldDto> selectAll() {
		List<FieldDto> fieldList = fieldDao.selectAll();
		List<ReservationDto> rList = reservationDao.selectAll();
		int count = 0;
		for (int j=0; j<fieldList.size(); j++) {
			List<ReservationDto> tempList = new ArrayList<ReservationDto>();
			for (int i = 0; i < rList.size(); i++) {
				
				if (fieldList.get(j).getF_name().equals(rList.get(i).getR_fname())) {
					tempList.add(rList.get(i));
				}
			}
			if(tempList.size() > 1) {
				fieldList.remove(j);
			}
		}

		return fieldList;
	}

	@Override
	public FieldDto findByName(String u_id) {
		// TODO Auto-generated method stub
		return fieldDao.findByName(u_id);
	}

	@Override
	public int update(FieldDto fieldDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fieldReservation(String imageName, UserDto userDto) {
		FieldDto fieldDto = fieldDao.findByImageName(imageName);
		return reservationDao.insert(fieldDto.getF_name(), userDto.getU_team(), userDto.getU_name());
	}

	@Override
	public List<ReservationDto> ReservationList(String fieldName) {
		return reservationDao.reservationList(fieldName);
	}

	@Override
	public int finishMatch(long seq) {

		return reservationDao.delete(seq);
	}

}
