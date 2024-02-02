package com.gechan.projectshop.service.impl;

import com.gechan.projectshop.models.etc.ImageDto;
import com.gechan.projectshop.service.FileService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    protected final ResourceLoader resourceLoader;
    protected final Resource resource;
    protected final String filePath;
    // protected final String macPath;
    // protected final String macHome;

    public FileServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.filePath = "/Users/isechan/Documents/workspace/files/";
        this.resource = resourceLoader.getResource("file:///Users/isechan/Documents/workspace/files/");
        // this.macPath = "/Users/isechan/Documents";
        // this.macHome = "/workspace/files";
    }
    @Override
    public String fileUp(MultipartFile file) throws Exception {
        File path = new File(filePath);
        if (!path.exists()) {
            path.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        String strUUID = UUID.randomUUID().toString();

        fileName = String.format("%s-%s", strUUID, fileName);
        File uploadFile = new File(path, fileName);
        file.transferTo(uploadFile);

        return fileName;
    }

    @Override
    public List<ImageDto> filesUp(MultipartHttpServletRequest files) throws Exception {

        return null;
    }
}
