package com.gechan.projectshop.models.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartOutDTO {
    private String p_name;
    private int p_price;
    private String p_image;
}
