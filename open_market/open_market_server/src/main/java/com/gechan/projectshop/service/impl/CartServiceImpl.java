package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.CartRepository;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.models.user.CartDto;
import com.gechan.projectshop.models.user.CartOutDTO;
import com.gechan.projectshop.service.CartService;
import com.gechan.projectshop.service.ProductService;
import com.gechan.projectshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserService userService;
    private final ProductService productService;


    public CartServiceImpl(CartRepository cartRepository
            , UserService userService
            , ProductService productService) {
        this.cartRepository = cartRepository;
        this.userService = userService;
        this.productService = productService;

    }

    @Override
    public List<CartOutDTO> prodSaveCart(String u_id, long p_seq) {
        if (userService.findById(u_id) != null) {
            CartDto cart = new CartDto();
            cart.setCa_pseq(p_seq);
            cart.setCa_uId(u_id);
            cartRepository.save(cart);
        }

        return this.loadCartProd(u_id);
    }

    @Override
    public List<CartOutDTO> loadCartProd(String u_id) {
        log.debug("{} 유저의 카트", u_id);
        List<CartDto> list = cartRepository.findByList(u_id);
        log.debug("카트 담긴 개수 {}", list.size());
        for (int i = 0; i < list.size(); i++) {
            log.debug("상품 : {}", list.get(i));
        }
        List<CartOutDTO> outDTOList = new ArrayList<>();
        if (list != null) {

            for (CartDto dto : list) {
                log.debug("카트 상품 : {}", dto.getCa_pseq());
                CartOutDTO outDTO = new CartOutDTO();
                ProductDto prod = productService.findById(dto.getCa_pseq());
                outDTO.setP_name(prod.getP_name());
                outDTO.setP_image(prod.getP_main_image_name());
                outDTO.setP_price(prod.getP_price());
                outDTOList.add(outDTO);
            }
        }
        return outDTOList;
    }

    @Override
    public CartDto cartProdDelete(long p_seq, String u_id) {
        return null;
    }
}
