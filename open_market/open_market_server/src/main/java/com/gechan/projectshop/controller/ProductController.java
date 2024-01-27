package com.gechan.projectshop.controller;

import com.gechan.projectshop.models.product.CategoryVO;
import com.gechan.projectshop.models.product.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
public class ProductController {

    public ProductDto uploadItem(
            @RequestParam("p_category") String p_category,
            @RequestParam("p_name") String p_name,
            @RequestParam("p_text") String p_text,
            @RequestParam("p_price") int p_price,
            @RequestParam("p_main_image") MultipartFile p_main_image,
            @RequestParam("p_images") MultipartFile[] p_images
            ) {
        ProductDto product = new ProductDto();
        CategoryVO category = new CategoryVO();
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
