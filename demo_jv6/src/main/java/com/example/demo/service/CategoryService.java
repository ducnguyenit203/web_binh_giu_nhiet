package com.example.demo.service;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    Category create(Category category);

    Category update(Category category);

    void delete(Integer id);
}
