package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.user.CartOutDTO;
import com.gechan.projectshop.service.CartService;
import com.gechan.projectshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
    }

    @GetMapping("/product/item/cartIn")
    public List<CartOutDTO> cartSave(String u_id, long p_seq) {

        return cartService.prodSaveCart(u_id, p_seq);
    }

    @PostMapping("/cartLoad")
    public List<CartOutDTO> cartLoad(@RequestBody String u_id) {
        log.debug("카트 불러오기 호출");
        return cartService.loadCartProd(u_id);
    }
}
