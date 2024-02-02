package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.models.user.UserDto;
import com.gechan.projectshop.service.FileService;
import com.gechan.projectshop.service.ImageService;
import com.gechan.projectshop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {

    private final FileService fileService;
    private final ImageService imageService;
    private final ProductService productService;

    @Autowired
    public ProductController(FileService fileService, ImageService imageService, ProductService productService) {
        this.fileService = fileService;
        this.imageService = imageService;
        this.productService = productService;
    }

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

        // 카테고리 등록
        CategoryVO category = new CategoryVO();
        category.setC_name(p_category);
        log.debug("카테고리 정보 : {}", category.toString());


        ProductDto product = new ProductDto();
        product.setP_name(p_name); // 상품 이름
        product.setP_uid(u_id); // 판매자
        product.setP_text(p_text); // 상품 설명
        product.setP_price(p_price); // 상품 가격
        String uploadDate;
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
        productService.prodUpload(product);

        log.debug("이미지 이름 : {}", p_main_image.getOriginalFilename());
        // 상품 등록하고 seq 값 받아오고


        try {
            if (!p_main_image.getOriginalFilename().isEmpty()) {

                String fileName = fileService.fileUp(p_main_image);
                // log.debug("업로드된 파일 이름 : {}", fileName);
                String originalFilename = p_main_image.getOriginalFilename();
                ImageDto imageDto = new ImageDto();
                imageDto.setI_image_name(fileName);
                // imageDto.setI_pseq();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.debug("=================상품 등록 끝 =================");
        return null;
    }
}
