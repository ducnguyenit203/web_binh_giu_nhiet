package com.example.demo.service;

import com.example.demo.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    List<Account> getAdministrators();

    Account findById(String id);

    Account create(Account account);

    Account update(Account account);

    void delete(String id);
}
