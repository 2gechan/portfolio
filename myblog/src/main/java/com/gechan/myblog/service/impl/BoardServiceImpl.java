package com.gechan.myblog.service.impl;

import com.gechan.myblog.models.BoardDto;
import com.gechan.myblog.models.CategoryVO;
import com.gechan.myblog.repository.BoardRepository;
import com.gechan.myblog.repository.CategoryRepository;
import com.gechan.myblog.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    public BoardServiceImpl(BoardRepository boardRepository, CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public int pageCount() {
        int boardAllCount = boardRepository.boardCount();
        System.out.println("게시글 총 개수 : " + boardAllCount);
        int pageCount = boardAllCount / 10;

        if (boardAllCount % 10 > 0) {
            pageCount++;
        }
        return pageCount;
    }

    @Override
    public List<BoardDto> boardList(int page) {
        // List<BoardDto> boardList = boardRepository.findAll();
        int offset = (page-1) * 10;
        List<BoardDto> boardList = boardRepository.pageToBoard(offset);
        return boardList;
    }

    @Override
    public BoardDto findById(long b_seq) {
        BoardDto dto = boardRepository.findById(b_seq).orElse(null);
        return dto;
    }

    @Override
    public List<CategoryVO> categoryList() {
        List<CategoryVO> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public List<BoardDto> categoryBoardList(String category) {
        long cate = Long.parseLong(category);
        CategoryVO categoryVO;
        categoryVO = categoryRepository.findById(cate).orElse(null);
        if (categoryVO == null) {
            return null;
        } else {
            List<BoardDto> categoryBoardList = boardRepository.findByCategoryInBoard(categoryVO.getCategory());
            return categoryBoardList;
        }


    }

    @Override
    public BoardDto insert(BoardDto dto) {
        BoardDto newBoard = boardRepository.save(dto);
        CategoryVO category = categoryRepository.findByCategory(dto.getB_category());

        if (category == null) {
            category = new CategoryVO();
            category.setCategory(dto.getB_category());
            categoryRepository.save(category);
        }
        return newBoard;
    }

    @Override
    public BoardDto update(BoardDto dto) {
        return null;
    }

    @Override
    public void delete(long b_seq) {
        BoardDto dto = boardRepository.findById(b_seq).orElse(null);
        if (dto != null) {
            String category = dto.getB_category();
            int count = boardRepository.findCategoryCount(category);
            System.out.println(count);
            if (count == 1) {
                CategoryVO categoryVO = categoryRepository.findByCategory(category);
                categoryRepository.delete(categoryVO);
            }
        }

        boardRepository.deleteById(b_seq);

    }
}
