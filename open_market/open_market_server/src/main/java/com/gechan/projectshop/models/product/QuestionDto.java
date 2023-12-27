package com.gechan.projectshop.models.product;

import javax.persistence.*;

@Table(name = "shop_question")
@Entity
public class QuestionDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long q_seq; // 상품 문의 seq

    @Column(nullable = false)
    private long q_pseq; // 상품 seq

    @Column(nullable = false, length = 25)
    private String q_uid; // 작성자 아이디

    @Column(nullable = false, length = 50)
    private String q_title; // 상품 문의 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String q_text; // 문의 내용

    @Column(nullable = false)
    private boolean q_chk; // 비밀글 체크 여부

    @Column(nullable = false, length = 10)
    private String q_date; // 작성 일자
}
