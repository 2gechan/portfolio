package com.gechan.projectshop.service;

import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.models.user.CartDto;
import com.gechan.projectshop.models.user.CartOutDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    public ProductDto prodUpload(ProductDto dto, String c_name, MultipartFile file, MultipartFile[] files); // 상품 등록
    public List<ProductDto> prodListSelect(long c_seq); // 카테고리별 상품 불러오기
    public String prodDelete(long p_seq); // 상품 삭제

    public String prodSoldOut(String yesOrNo);

    public List<CategoryVO> loadAllCategory();

    public ProductDto prodDetail(long p_seq);

    public List<ImageDto> detailImages(long p_seq);

    public int likeCountPlus(long p_seq);

    public ProductDto findById(long p_seq);

}
