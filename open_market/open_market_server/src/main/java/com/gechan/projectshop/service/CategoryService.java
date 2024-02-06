package com.gechan.projectshop.service;

import com.gechan.projectshop.Repository.CategoryRepository;
import com.gechan.projectshop.models.product.CategoryVO;

import java.util.List;

public interface CategoryService {

    public long findCategory(String c_name);

    public List<CategoryVO> loadAllCategory();
}
