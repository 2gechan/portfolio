package com.gechan.projectshop.models.user;

import javax.persistence.*;

@Table(name = "shop_user")
@Entity
public class UserDto {

    @Id
    @Column(length = 25)
    private String u_id; // 아이디

    @Column(nullable = false, length = 125)
    private String u_password; // 패스워드

    @Column(nullable = false, length = 25)
    private String u_name; // 실제 이름

    @Column(nullable = false, length = 25)
    private String u_nickname; // 닉네임

    @Column(nullable = false, length = 15)
    private String u_phone; // 전화번호

    private int u_point; // 예치금

}
