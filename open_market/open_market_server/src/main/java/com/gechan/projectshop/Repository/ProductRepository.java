package com.gechan.projectshop.Repository;

import com.gechan.projectshop.models.product.ProductDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, Long> {

    @Query(value = "select * from shop_product p where p.p_cseq = :c_seq", nativeQuery = true)
    public List<ProductDto> prodInCategory(long c_seq);
}
