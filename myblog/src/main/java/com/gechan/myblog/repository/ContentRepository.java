package com.gechan.myblog.repository;

import com.gechan.myblog.models.ContentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<ContentDto, Long> {
}
