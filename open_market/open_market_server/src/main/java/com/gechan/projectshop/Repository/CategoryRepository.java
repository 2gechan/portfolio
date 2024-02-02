package com.gechan.projectshop.Repository;

import com.gechan.projectshop.models.product.CategoryVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryVO, Long> {
}
