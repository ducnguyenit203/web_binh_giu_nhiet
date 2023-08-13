package com.example.demo.rest;

import com.example.demo.entity.Role;
import com.example.demo.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class RoleRestController {
    @Autowired
    private RoleServiceImpl service;

    @GetMapping("/roles")
    public List<Role> getAll(){
        return service.findAll();
    }
}
