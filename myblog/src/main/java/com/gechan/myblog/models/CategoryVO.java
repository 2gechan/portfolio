package com.gechan.myblog.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "category_list")
public class CategoryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ct_seq;
    private String category;
}
