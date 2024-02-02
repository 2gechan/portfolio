package com.gechan.projectshop.Repository;

import com.gechan.projectshop.models.product.CategoryVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryVO, Long> {

    @Query(value = "select * from shop_category c where c.c_name = :c_name", nativeQuery = true)
    public CategoryVO findByCName(String c_name);
}
