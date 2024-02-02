package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.Repository.ImageRepository;
import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageDto imageInsert(ImageDto imageDto) {
        return imageRepository.save(imageDto);
    }

    @Override
    public List<ImageDto> detailImage(long i_pseq) {
        List<ImageDto> detailImages = imageRepository.prodDetailImages(i_pseq);
        return detailImages;
    }
}
