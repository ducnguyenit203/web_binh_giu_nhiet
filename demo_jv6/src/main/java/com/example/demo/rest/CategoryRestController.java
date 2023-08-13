package com.example.demo.rest;

import com.example.demo.entity.Category;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest")
public class CategoryRestController {
    @Autowired
    private CategoryServiceImpl service;

    @GetMapping("/categories")
    public ResponseEntity<?>getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public Category getOne(@PathVariable("id")Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Category creat(@RequestBody Category category ) {
        return service.create(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id")String id,@RequestBody Category category ) {
        return service.update(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id")Integer id) {
        service.delete(id);
    }

}
