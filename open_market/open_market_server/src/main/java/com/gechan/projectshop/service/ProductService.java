package com.gechan.projectshop.service;

import com.gechan.projectshop.models.product.ProductDto;

import java.util.List;

public interface ProductService {

    public ProductDto prodUpload(ProductDto dto); // 상품 등록
    public List<ProductDto> prodListSelect(); // 전체 상품 불러오기
    public String prodDelete(long p_seq); // 상품 삭제

    public String prodSoldOut(String yesOrNo);
}
