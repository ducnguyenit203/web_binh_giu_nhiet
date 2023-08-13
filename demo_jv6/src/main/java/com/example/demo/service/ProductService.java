package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategoryId(Integer cid);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);

    List<Product> findByPrice(double min, double max);

    List<Product> findByName(String name);
}
