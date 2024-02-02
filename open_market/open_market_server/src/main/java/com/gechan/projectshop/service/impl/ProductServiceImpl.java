package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.ProductRepository;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto prodUpload(ProductDto dto) {
        ProductDto pDto = productRepository.save(dto);
        return pDto;
    }

    @Override
    public List<ProductDto> prodListSelect() {
        return null;
    }

    @Override
    public String prodDelete(long p_seq) {
        return null;
    }

    @Override
    public String prodSoldOut(String yesOrNo) {
        return null;
    }
}
