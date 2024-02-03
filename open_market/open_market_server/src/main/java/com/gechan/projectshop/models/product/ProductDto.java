package com.gechan.projectshop.models.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "shop_product")
public class ProductDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long p_seq; // seq

    @Column(nullable = false, length = 25)
    private String p_uid; // 판매자ID, 참조키

    @Column(nullable = false)
    private long p_cseq; // 카테고리 seq, 참조

    @Column(nullable = false, length = 125)
    private String p_name; // 상품 이름

    @Column(nullable = false, columnDefinition = "TEXT")
    private String p_text; // 상품 설명

    @Column(nullable = false)
    private int p_price; // 상품 가격

    @Column(nullable = false, length = 20)
    private String p_update; // 등록일자

    @Column(nullable = false)
    private boolean p_yesNo; // 판매 유무

    private int p_like; // 찜 개수
}
