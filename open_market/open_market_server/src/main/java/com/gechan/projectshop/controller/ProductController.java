package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.models.product.ProductDto;
import com.gechan.projectshop.models.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {

    @PostMapping("uploadItem")
    public ProductDto uploadItem(
            @RequestParam("p_category") String p_category,
            @RequestParam("p_name") String p_name,
            @RequestParam("p_text") String p_text,
            @RequestParam("p_price") int p_price,
            @RequestParam("p_main_image") MultipartFile p_main_image,
            @RequestParam(value = "p_images", required = false) MultipartFile[] p_images,
            HttpSession httpSession
            ) {
        UserDto loginUser = (UserDto) httpSession.getAttribute("LOGINUSER");
        log.debug("현재 사용자 : {}", loginUser.toString());
        ProductDto product = new ProductDto();
        product.setP_name(p_name);
        product.setP_text(p_text);
        product.setP_price(p_price);
        log.debug("상품 정보 : {}", product.toString());
        CategoryVO category = new CategoryVO();
        category.setC_name(p_category);
        log.debug("카테고리 정보 : {}", category.toString());

        ImageDto imageDto = new ImageDto();
        log.debug("이미지 이름 : {}", p_main_image.getOriginalFilename());
        /*
        try {
            if (!p_main_image.getOriginalFilename().isEmpty()) {
                String fileName = fileService.fileUp(p_main_image);
                returnDto.setP_main_image(fileName);
                productService.insert(returnDto);

            }
            for (MultipartFile image : images) {
                if(!image.isEmpty()) {
                    String fileName = fileService.fileUp(image);
                    ImageVO imageVO = new ImageVO();
                    imageVO.setI_image_name(fileName);
                    long pseq = productService.findLastProduct();
                    log.debug("마지막 인덱스 {}", pseq);
                    imageVO.setI_pseq(pseq);

                    imagesService.imagesInsert(imageVO);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        return null;
    }
}
