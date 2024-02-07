package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.ImageRepository;
import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.service.FileService;
import com.gechan.projectshop.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final FileService fileService;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository, FileService fileService) {
        this.imageRepository = imageRepository;
        this.fileService = fileService;
    }

    @Override
    public String imageInsert(MultipartFile image, MultipartFile[] images, long p_seq) {
        String originalFilename = image.getOriginalFilename();
        log.debug("업로드된 파일 이름 : {}", originalFilename);
        String p_main_image_name = "FAIL";

        try {
            if (!(originalFilename.isEmpty() || originalFilename == null || originalFilename.isBlank())) {
                String fileName = fileService.fileUp(image);
                p_main_image_name = fileName;
                ImageDto imageDto = new ImageDto();
                imageDto.setI_pseq(p_seq);
                imageDto.setImageTypeCd("m");
                imageDto.setI_image_name(fileName);
                imageRepository.save(imageDto);
            }
            log.debug("서브 이미지 업로드 시작");
            log.debug("이미지 개수 : {}", images.length);
            for (MultipartFile file : images) {
                if (!file.isEmpty()) {
                    String fileName = fileService.fileUp(file);
                    ImageDto imageDto = new ImageDto();
                    imageDto.setI_pseq(p_seq);
                    imageDto.setImageTypeCd("s");
                    imageDto.setI_image_name(fileName);
                    imageRepository.save(imageDto);
                }
            }
            log.debug("서브 이미지들 업로드 끝");
        } catch (Exception e) {
            log.debug("업로드 에러");
            return "FAIL";
        }
        if (p_main_image_name.equals("FAIL")) return p_main_image_name;
        else return p_main_image_name;

    }

    @Override
    public List<ImageDto> detailImage(long i_pseq) {
        List<ImageDto> detailImages = imageRepository.prodDetailImages(i_pseq);
        return detailImages;
    }
}
