package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.CategoryRepository;
import com.gechan.projectshop.Repository.ProductRepository;
import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.service.ImageService;
import com.gechan.projectshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageService imageService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ImageService imageService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.imageService = imageService;
    }

    @Override
    public ProductDto prodUpload(ProductDto dto, String c_name, MultipartFile file, MultipartFile[] files) {

        // imageService.imageInsert()


        CategoryVO categoryVO = categoryRepository.findByCName(c_name);
        long p_cseq;
        if (categoryVO == null) {
            categoryVO = new CategoryVO();
            categoryVO.setC_name(c_name);
            categoryVO.setC_pcount(0);
            categoryVO = categoryRepository.save(categoryVO);
        }
        p_cseq = categoryVO.getC_seq();
        categoryVO.setC_pcount(categoryVO.getC_pcount() + 1);
        categoryRepository.save(categoryVO);

        dto.setP_cseq(p_cseq);
        ProductDto pDto = productRepository.save(dto);

        String result = imageService.imageInsert(file, files, pDto.getP_seq());
        if (result.equals("FAIL")) {
            return null;
        }
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
