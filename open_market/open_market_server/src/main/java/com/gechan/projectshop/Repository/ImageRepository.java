package com.gechan.projectshop.Repository;

import com.gechan.projectshop.models.etc.ImageDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageDto, Long> {

    // 상품 pk인 시퀀스 값을 받아 인자 값으로 전달하여 상품에 대한 디테일 이미지 받아오기
    // 메인 이미지는 상품dto에 들어있기때문에 서브이미지들만 불러오기
    @Query(value = "select * from shop_product_image i where i.i_pseq = :i_pseq AND i.image_type_cd = 's'", nativeQuery = true)
    public List<ImageDto> prodDetailImages(long i_pseq);
}
