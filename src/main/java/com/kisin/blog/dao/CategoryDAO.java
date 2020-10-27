package com.kisin.blog.dao;

import com.kisin.blog.pojo.Category;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Integer> {
    void deleteByName(@Param("name") String name);
}
