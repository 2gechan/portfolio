package com.gechan.projectshop.models.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDto {
    private String ca_uId; // 유저아이디
    private long ca_pseq; // 상품번호

}
