package com.example.demo.service;

import com.example.demo.entity.Authority;

import java.util.List;

public interface AuthorityService {
    public List<Authority> findAuthoritiesOfAdministrators();

    public List<Authority> findAll();

    public Authority create(Authority auth);

    public void delete(Integer id);
}
