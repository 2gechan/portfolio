package com.gechan.myblog.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "blog_content")
public class ContentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long c_seq;
    private String c_category;
    private String c_date;
    private String c_content;

}
