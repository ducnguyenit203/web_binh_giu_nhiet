package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
    @Query("SELECT DISTINCT a.account FROM Authority a WHERE a.role.id IN ('DIRE','STAF')")
    List<Account> getAdministrators();

    @Query("SELECT a FROM Account a WHERE a.fullname = ?1")
    Account findByFullname(String username);
}
