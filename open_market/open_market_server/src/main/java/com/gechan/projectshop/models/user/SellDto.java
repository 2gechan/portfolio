package com.gechan.projectshop.models.user;

import javax.persistence.*;

@Table(name = "shop_sell")
@Entity
public class SellDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_seq; // 판매내역 seq

    @Column(nullable = false, length = 25)
    private String s_uid; // 판매자 아이디

    @Column(nullable = false)
    private long s_pseq; // 판매된 상품 seq
}
