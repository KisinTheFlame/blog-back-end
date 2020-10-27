package com.kisin.blog.dao;

import com.kisin.blog.pojo.Article;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleDAO extends JpaRepository<Article, Integer> {
    @Query(value = "SELECT * FROM article ORDER BY created_time DESC LIMIT :offset , :rows"
            , nativeQuery = true)
    List<Article> getArticleListOrderedByCreatedTime(@Param("offset") int offset, @Param("rows") int rows);

    @Query(value = "SELECT * FROM article WHERE category LIKE :category ORDER BY created_time DESC LIMIT :offset , :rows"
            , nativeQuery = true)
    List<Article> getArticleListOfCategoryOrderedByCreatedTime(@Param("category") String category, @Param("offset") int offset, @Param("rows") int rows);

    long countByCategoryLike(@Param("category") String category);

    long count();
}
