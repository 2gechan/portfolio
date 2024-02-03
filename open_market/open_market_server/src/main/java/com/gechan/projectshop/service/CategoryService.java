package com.gechan.projectshop.service;

import com.gechan.projectshop.Repository.CategoryRepository;
import com.gechan.projectshop.models.product.CategoryVO;

public interface CategoryService {

    public long findCategory(String c_name);
}
