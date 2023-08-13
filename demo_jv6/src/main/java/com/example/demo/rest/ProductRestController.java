package com.example.demo.rest;

import com.example.demo.entity.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {

    @Autowired
    private ProductServiceImpl service;

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable("id")Integer id) {
        return service.findById(id);
    }
//	@GetMapping("/find/{name}")
//	public List <Product> getName(@PathVariable("name")String name) {
//		return productService.findByName(name);
//	}

    @GetMapping("/find/{name}")
    public ResponseEntity<List<Product>> findProductsByName(@PathVariable String name) {
        List<Product> products = service.findByName(name);
        if (products == null || products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping
    public Product creat(@RequestBody Product product ) {
        return service.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable("id")Integer id,@RequestBody Product product ) {
        return service.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id) {
        service.delete(id);
    }


}
