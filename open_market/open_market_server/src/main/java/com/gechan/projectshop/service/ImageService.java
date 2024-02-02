package com.gechan.projectshop.service;

import com.gechan.projectshop.models.etc.ImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    public String imageInsert(MultipartFile file, MultipartFile[] files, long p_seq);

    public List<ImageDto> detailImage(long i_pseq);


}
