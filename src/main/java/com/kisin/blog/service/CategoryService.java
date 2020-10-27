package com.kisin.blog.service;

import com.kisin.blog.dao.CategoryDAO;
import com.kisin.blog.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    public void create(Category category) {
        categoryDAO.save(category);
    }

    public long count() {
        return categoryDAO.count();
    }

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    public void deleteByName(String name) {
        categoryDAO.deleteByName(name);
    }
}
