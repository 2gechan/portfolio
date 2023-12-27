package com.gechan.projectshop.models.user;

import javax.persistence.*;

@Table(name = "shop_buy")
@Entity
public class BuyDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long b_seq; // 구매내역 seq

    @Column(nullable = false, length = 25)
    private String b_uid; // 구매자 아이디

    @Column(nullable = false)
    private long b_pseq; // 구매한 상품 seq
}
