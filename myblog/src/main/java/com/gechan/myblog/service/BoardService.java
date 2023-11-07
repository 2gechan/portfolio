package com.gechan.myblog.service;

import com.gechan.myblog.models.BoardDto;
import com.gechan.myblog.models.CategoryVO;

import java.util.List;

public interface BoardService {

    public List<BoardDto> boardList(int page);

    public List<BoardDto> categoryBoardList(String category);

    public BoardDto insert(BoardDto dto);

    public BoardDto update(BoardDto dto);

    public void delete(long b_seq);

    public List<CategoryVO> categoryList();

    public BoardDto findById(long b_seq);

    public int pageCount();
}
