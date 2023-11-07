package com.gechan.myblog.service.impl;

import com.gechan.myblog.models.ContentDto;
import com.gechan.myblog.repository.ContentRepository;
import com.gechan.myblog.service.ContentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;
    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<ContentDto> selectAll() {
        List<ContentDto> contentList = contentRepository.findAll();
        return contentList;
    }

    @Override
    public ContentDto insert(ContentDto dto) {
        ContentDto contentDto = contentRepository.save(dto);
        return contentDto;
    }

    @Override
    public ContentDto update(ContentDto dto) {
        return null;
    }

    @Override
    public int delete(long c_seq) {
        return 0;
    }
}
