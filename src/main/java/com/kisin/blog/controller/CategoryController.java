package com.kisin.blog.controller;

import com.kisin.blog.pojo.Category;
import com.kisin.blog.result.Result;
import com.kisin.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kisin.blog.result.ResultCode.SUCCESS;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "api/create-new-category")
    @CrossOrigin
    @ResponseBody
    public Result create(@RequestBody Category category) {
        categoryService.create(category);
        return new Result(SUCCESS);
    }

    @GetMapping(value = "api/get-category-count")
    @CrossOrigin
    @ResponseBody
    public Result count() {
        return new Result(SUCCESS, categoryService.count());
    }

    @GetMapping(value = "api/get-category-list")
    @CrossOrigin
    @ResponseBody
    public Result findAll() {
        return new Result(SUCCESS, categoryService.findAll());
    }

    @PostMapping(value = "api/delete-category/{name}")
    @CrossOrigin
    @ResponseBody
    public Result deleteByName(@PathVariable("name") String name) {
        categoryService.deleteByName(name);
        return new Result(SUCCESS);
    }
}
