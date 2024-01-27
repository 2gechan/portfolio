package com.gechan.projectshop.service;

import com.gechan.projectshop.models.etc.ImageDto;

import java.util.List;

public interface ImageService {
    public ImageDto imageInsert(ImageDto imageDto);

    public List<ImageDto> detailImage(long i_pseq);


}
