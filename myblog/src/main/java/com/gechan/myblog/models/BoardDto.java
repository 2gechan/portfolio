package com.gechan.myblog.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "board_content")
public class BoardDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long b_seq;
    private String b_category;
    private String b_title;
    private String b_writer;
    private String b_text;
    private String b_date;
}
