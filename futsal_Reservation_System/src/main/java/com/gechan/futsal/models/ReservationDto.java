package com.gechan.futsal.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
	
	private long r_seq;
	private String r_fname;
	private String r_uteam;
	private String r_uname;

}
