package com.gechan.projectshop.models.etc;

import javax.persistence.*;

@Table(name = "shop_report")
@Entity
public class ReportDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long r_seq; // 신고 접수 seq

    @Column(nullable = false)
    private long r_pseq; // 신고된 상품 seq

    @Column(nullable = false, length = 25)
    private String r_puid; // 신고된 상품 판매자 아이디

    @Column(nullable = false, length = 50)
    private String r_category; // 신고 유형 ex) 사기, 불건전 상품 등

    @Column(nullable = false, columnDefinition = "TEXT")
    private String r_text; // 신고 접수 상세 내용

    @Column(nullable = false, length = 10)
    private String r_date; // 신고 접수 날짜

    @Column(nullable = false, length = 25)
    private String r_uid; // 신고 접수한 사용자
}
