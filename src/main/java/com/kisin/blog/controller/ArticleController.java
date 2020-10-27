package com.kisin.blog.controller;

import com.kisin.blog.pojo.Article;
import com.kisin.blog.result.Result;
import com.kisin.blog.service.ArticleService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kisin.blog.result.ResultCode.SUCCESS;

class OffsetAndRows {
    private final int offset;
    private final int rows;

    public OffsetAndRows(@Param("offset") int offset, @Param("rows") int rows) {
        this.offset = offset;
        this.rows = rows;
    }

    public int getOffset() {
        return offset;
    }

    public int getRows() {
        return rows;
    }
}

@CrossOrigin
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "api/article-list/{category}")
    @ResponseBody
    public List<Article> getArticleListOrderedByCreatedTime(@PathVariable("category") String category, @RequestBody OffsetAndRows offsetAndRows) {
        return articleService.getArticleListOrderedByCreatedTime(category, offsetAndRows.getOffset(), offsetAndRows.getRows());
    }

    @GetMapping(value = "api/total-of-articles/{category}")
    @ResponseBody
    public long getTotalOfArticles(@PathVariable("category") String category) {
        return articleService.getTotalOfArticles(category);
    }

    @PostMapping(value = "api/admin/upload-article")
    @ResponseBody
    public Result save(@Param("article") @RequestBody Article article) {
        System.out.println("Article received.");
        articleService.save(article);
        return new Result(SUCCESS);
    }
}
