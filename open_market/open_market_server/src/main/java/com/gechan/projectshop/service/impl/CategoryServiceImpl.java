package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.CategoryRepository;
import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public long findCategory(String c_name) {
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
        return p_cseq;
    }
}
