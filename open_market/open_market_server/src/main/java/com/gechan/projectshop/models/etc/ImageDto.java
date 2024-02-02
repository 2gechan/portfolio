package com.gechan.projectshop.models.etc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "shop_product_image")
public class ImageDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long i_seq;

    private long i_pseq; // 상품 시퀀스
    private String i_image_name;
    private String imageTypeCd; // 메인 이미지 m, 서브 이미지, s
}
