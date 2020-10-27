package com.kisin.blog.service;

import com.kisin.blog.dao.ArticleDAO;
import com.kisin.blog.dao.CategoryDAO;
import com.kisin.blog.pojo.Article;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleDAO articleDAO;

    public List<Article> getArticleListOrderedByCreatedTime(@Param("category") String category, @Param("offset") int offset, @Param("rows") int rows) {
        if (category.equals("all")) return articleDAO.getArticleListOrderedByCreatedTime(offset, rows);
        return articleDAO.getArticleListOfCategoryOrderedByCreatedTime("%" + category + "%", offset, rows);
    }

    public long getTotalOfArticles(@Param("category") String category) {
        if (category.equals("all")) return articleDAO.count();
        return articleDAO.countByCategoryLike("%" + category + "%");
    }

    public void save(Article article) {
        articleDAO.save(article);
    }
}
