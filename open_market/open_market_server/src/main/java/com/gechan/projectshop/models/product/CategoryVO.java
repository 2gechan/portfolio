package com.gechan.projectshop.models.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "shop_category")
public class CategoryVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long c_seq; // seq

    @Column(nullable = false, length = 25)
    private String c_name; // 카테고리 이름

    private int c_pcount; // 카테고리에 포함된 상품 총 개수
}
