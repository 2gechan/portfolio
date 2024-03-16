package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.models.user.CartDto;
import com.gechan.projectshop.models.user.UserDto;
import com.gechan.projectshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 상품 업로드
    @PostMapping("uploadItem")
    public ProductDto uploadItem(
            @RequestParam("p_category") String p_category,
            @RequestParam("u_id") String u_id,
            @RequestParam("p_name") String p_name,
            @RequestParam("p_text") String p_text,
            @RequestParam("p_price") int p_price,
            @RequestParam("p_main_image") MultipartFile p_main_image,
            @RequestParam(value = "p_images", required = false) MultipartFile[] p_images,
            HttpSession httpSession
            ) {
        UserDto loginUser = (UserDto) httpSession.getAttribute("LOGINUSER");
        log.debug("=================상품 등록 시작 =================");
        // log.debug("업로드 사용자 : {}", loginUser.toString());

        ProductDto product = new ProductDto();
        product.setP_name(p_name); // 상품 이름
        product.setP_uid(u_id); // 판매자
        product.setP_text(p_text); // 상품 설명
        product.setP_price(p_price); // 상품 가격
        String uploadDate;

        // 등록 날짜 생성
        {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String strDate = dateFormat.format(date);
            String strTime = timeFormat.format(date);
            uploadDate = strDate + " " + strTime;
        }

        product.setP_update(uploadDate); // 등록일자
        product.setP_yesNo(true); // 판매 유무
        product.setP_like(0); // 찜 개수
        log.debug("상품 정보 : {}", product.toString());
        ProductDto pDto = productService.prodUpload(product, p_category, p_main_image, p_images);

        log.debug("=================상품 등록 끝 =================");
        return pDto;
    }

    // =============================== 상품 메인 페이지 ===============================

    @GetMapping("/ctgyList")
    public List<CategoryVO> categoryList () {

        return productService.loadAllCategory();
    }

    @GetMapping("/prodList")
    public List<ProductDto> productLList(@RequestParam("c_seq") String c_seq) {
        long seq = Integer.parseInt(c_seq);
        return productService.prodListSelect(seq);
    }


    // =============================== 상품 메인 페이지 ===============================

    // =============================== 상품 디테일 페이지 ===============================

    @GetMapping("/product/item/detail")
    public ProductDto prodDetailPage(@RequestParam("p_seq") String p_seq) {
        long seq = Integer.parseInt(p_seq);
        ProductDto pInfo = productService.prodDetail(seq);
        log.debug("상품 정보 : {}", pInfo.toString());
        return pInfo;
    }

    @GetMapping("/product/item/detailImage")
    public List<ImageDto> subImageRetv(@RequestParam("p_seq") String p_seq) {
        long seq = Integer.parseInt(p_seq);
        return productService.detailImages(seq);
    }

    @GetMapping("/product/item/likeCount")
    public int likeCountPlus(@RequestParam("p_seq") String p_seq) {
        long prodSeq = Integer.parseInt(p_seq);
        // log.debug("상품 시퀀스 : {}", prodSeq);
        return productService.likeCountPlus(prodSeq);
    }

    public CartDto cartIn(@RequestParam("p_seq") String p_seq, @RequestParam("u_id") String u_id) {
        CartDto cart = new CartDto();
        long seq = Integer.parseInt(p_seq);
        cart.setCa_pseq(seq);
        cart.setCa_uId(u_id);
        return cart;
    }


    // =============================== 상품 디테일 페이지 ===============================
}
