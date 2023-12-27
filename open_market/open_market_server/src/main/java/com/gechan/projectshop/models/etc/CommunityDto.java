package com.gechan.projectshop.models.etc;

import javax.persistence.*;

@Table(name = "shop_community_board")
@Entity
public class CommunityDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cb_seq; // 소통 게시판 글 seq

    @Column(nullable = false, length = 25)
    private String cb_uid; // 작성자 아이디

    @Column(nullable = false, length = 50)
    private String cb_title; // 글 제목

    @Column(nullable = false, length = 25)
    private String cb_nickname; // 작성자 닉네임

    @Column(nullable = false, columnDefinition = "TEXT")
    private String cb_text; // 글 상세 내용

    @Column(nullable = false, length = 10)
    private String cb_date; // 글 등록 일자

    private int cb_viewcount; // 조회수
}
