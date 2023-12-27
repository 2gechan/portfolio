package com.gechan.projectshop.models.product;

import javax.persistence.*;

@Table(name = "shop_product_image")
@Entity
public class ProductImageDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long i_seq; // 이미지 seq

    @Column(nullable = false)
    private long i_pseq; // 상품 seq

    @Column(nullable = false)
    private String i_name; // 이미지 이름
}
