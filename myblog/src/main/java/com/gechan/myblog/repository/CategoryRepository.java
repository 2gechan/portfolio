package com.gechan.myblog.repository;

import com.gechan.myblog.models.CategoryVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryVO, Long> {
    @Query(value = "select * from category_list c where c.category=:b_category", nativeQuery = true)
    public CategoryVO findByCategory(String b_category);

}
