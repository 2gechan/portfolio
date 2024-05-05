package com.gechan.projectshop.Repository;

import com.gechan.projectshop.models.user.CartDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartDto, String> {

    @Query(value = "select * from shop_product_cart where ca_u_id = :u_id", nativeQuery = true)
    public List<CartDto> findByList(String u_id);
}
