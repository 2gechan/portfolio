package com.gechan.projectshop.Repository;

import com.gechan.projectshop.models.product.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Long> {
    public long insert(ProductDto dto);
}
