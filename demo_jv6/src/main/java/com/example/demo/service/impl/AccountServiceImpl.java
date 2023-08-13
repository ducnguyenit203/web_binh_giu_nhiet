package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Account> getAdministrators() {
        return repository.getAdministrators();
    }

    @Override
    public Account findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Account create(Account account) {
        return repository.save(account);
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
