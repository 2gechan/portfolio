package com.gechan.projectshop.service;

import com.gechan.projectshop.models.etc.ImageDto;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface FileService {
    public String fileUp(MultipartFile file) throws Exception;

    public List<ImageDto> filesUp(MultipartHttpServletRequest files) throws Exception;

}
