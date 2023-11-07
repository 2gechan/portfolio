package com.gechan.myblog.service;

import com.gechan.myblog.models.ContentDto;

import java.util.List;

public interface ContentService {

    public List<ContentDto> selectAll();

    public ContentDto insert(ContentDto dto);

    public ContentDto update(ContentDto dto);

    public int delete(long c_seq);
}
