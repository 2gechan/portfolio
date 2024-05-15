package com.gechan.projectshop.models.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "shop_product_cart")
public class CartDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ca_cseq; // 카트 시퀀스

    @Column(nullable = false)
    private String ca_u_id; // 유저아이디

    @Column(nullable = false)
    private long ca_pseq; // 상품번호

}
