package com.gechan.futsal.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gechan.futsal.models.FileDto;
import com.gechan.futsal.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileServiceImplV1 implements FileService {

	protected final ResourceLoader resourceLoader;
	protected final String filePath;
	protected final String macPath;
	protected final String macHome;

	public FileServiceImplV1(ResourceLoader resourceLoader, String macPath, String macHome) {
		this.resourceLoader = resourceLoader;
		this.filePath = "/Users/isechan/Documents/workspace/files/";
		this.macPath = macPath;
		this.macHome = macHome;
	}

	@Override
	public String fileUp(MultipartFile file) throws Exception {

		// Resource res = resourceLoader.getResource(filePath);

		// String savePath = res.getURI().getPath();
		// log.debug("저장 경로 : {}", savePath);
		// System.out.println("실행됬는지 체크");
		

		// String fileUpPath = macHome + macPath;

		// 파일이 저장될 mac 디렉토리 경로 설정
		// File path = new File(savePath);
		File path = new File(filePath);
		System.out.println("저장경로 : " + path);

		if (!path.exists()) {
			path.mkdirs(); // 디렉토리 생성
		}

		// 실제 업로드된 파일 이름
		String fileName = file.getOriginalFilename();

		// java에서 제공하는 uuid를 생성하는 코드
		String strUUID = UUID.randomUUID().toString();

		// UUID 키 값 파일 이름과 합성하여 새로운 이름으로 변형
		fileName = String.format("%s-%s", strUUID, fileName);
		File uploadFile = new File(path, fileName);
		file.transferTo(uploadFile);

		return fileName;
	}

	@Override
	public List<FileDto> filesUp(MultipartHttpServletRequest files) throws Exception {
		/*
		 * 멀티파일을 각 파일로 분리하여 fileUp() 에게 파일을 업로드하도록 요청하고, 원본이름과 변경된 이름을 받아서 returnFiles를
		 * 만들기
		 */
		List<MultipartFile> fileList = files.getFiles("f_images");

		List<FileDto> returnFiles = new ArrayList<FileDto>();
		for (MultipartFile file : fileList) {
			FileDto fileDto = new FileDto();

			fileDto.setI_originalName(file.getOriginalFilename());
			fileDto.setI_uploadName(this.fileUp(file));

			returnFiles.add(fileDto);
		}
		return returnFiles;
	}

	@Override
	public String delete(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
