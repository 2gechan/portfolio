package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.CartRepository;
import com.gechan.projectshop.Repository.CategoryRepository;
import com.gechan.projectshop.Repository.ProductRepository;
import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.models.user.CartDto;
import com.gechan.projectshop.models.user.CartOutDTO;
import com.gechan.projectshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ImageService imageService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository
            , CategoryService categoryService
            , ImageService imageService
            ) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.imageService = imageService;
    }

    @Override
    public ProductDto prodUpload(ProductDto dto, String c_name, MultipartFile file, MultipartFile[] files) {

        long p_cseq = categoryService.findCategory(c_name);

        dto.setP_cseq(p_cseq);
        ProductDto pDto = productRepository.save(dto);

        String result = imageService.imageInsert(file, files, pDto.getP_seq());
        if (result.equals("FAIL")) {
            return null; // 업로드에 실패했다고 알려줘야 함
        }
        pDto.setP_main_image_name(result);
        // save는 insert와 다르게 기존에 같은 데이터가 있으면 변경사항만 업데이트? 해준다
        pDto = productRepository.save(pDto);

        return pDto;
    }

    @Override
    public List<ProductDto> prodListSelect(long c_seq) {
        if (c_seq < 1) return productRepository.findAll(); // 전체
        else return productRepository.prodInCategory(c_seq); // 카테고리별
    }

    @Override
    public String prodDelete(long p_seq) {
        return null;
    }

    @Override
    public String prodSoldOut(String yesOrNo) {
        return null;
    }

    @Override
    public List<CategoryVO> loadAllCategory() {
        return categoryService.loadAllCategory();
    }

    @Override
    public ProductDto prodDetail(long p_seq) {
        ProductDto prodInfo = productRepository.findById(p_seq).orElse(null);
        return prodInfo;
    }

    @Override
    public List<ImageDto> detailImages(long p_seq) {
        return imageService.detailImage(p_seq);
    }

    @Override
    public int likeCountPlus(long p_seq) {
        ProductDto prod = productRepository.findById(p_seq).orElse(null);
        int like = 0;
        if (prod != null){
            like = prod.getP_like();
            like += 1;
            prod.setP_like(like);
            productRepository.save(prod);
        }
        return like;
    }

    @Override
    public ProductDto findById(long p_seq) {
        return productRepository.findById(p_seq).orElse(null);
    }
}
