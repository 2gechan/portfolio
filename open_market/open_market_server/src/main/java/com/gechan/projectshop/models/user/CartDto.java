package com.gechan.projectshop.models.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@Table(name = "shop_product_cart")
public class CartDto {
    @Id
    private String ca_uId; // 유저아이디
    private long ca_pseq; // 상품번호

}
