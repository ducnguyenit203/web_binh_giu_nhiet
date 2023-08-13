package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Authority;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository repository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = accountService.getAdministrators();
        return repository.authoritiesOf(accounts);
    }

    @Override
    public List<Authority> findAll() {
        return repository.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return repository.save(auth);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
