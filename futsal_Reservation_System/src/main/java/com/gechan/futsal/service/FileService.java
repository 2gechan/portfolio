package com.gechan.futsal.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gechan.futsal.models.FileDto;

public interface FileService {

	public String fileUp(MultipartFile file) throws Exception;

	public List<FileDto> filesUp(MultipartHttpServletRequest files) throws Exception;

	public String delete(String fileName);

}
