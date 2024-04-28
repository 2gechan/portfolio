package com.gechan.projectshop.service;

import com.gechan.projectshop.models.user.CartDto;
import com.gechan.projectshop.models.user.CartOutDTO;

import java.util.List;

public interface CartService {
    public List<CartOutDTO> prodSaveCart(String u_id, long p_seq);

    public List<CartOutDTO> loadCartProd(String u_id);
    public CartDto cartProdDelete(long p_seq, String u_id);
}
