package com.gechan.myblog.repository;

import com.gechan.myblog.models.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Long> {

    @Query(value = "select * from board_content b where b.b_category=:category", nativeQuery = true)
    public List<BoardDto> findByCategoryInBoard(String category);

    @Query(value = "select count(*) from board_content b where b.b_category=:category", nativeQuery = true)
    public int findCategoryCount(String category);

    @Query(value = "select count(*) from board_content", nativeQuery = true)
    public int boardCount();

    @Query(value = "select * from board_content limit 10 offset ?1", nativeQuery = true)
    public List<BoardDto> pageToBoard(int pageNum);
}
