package com.khesam.atm.simulator.repository;

import com.khesam.atm.simulator.repository.entity.Account;

import java.util.Optional;

public interface Database {

    void insert(Account account);
    Optional<Account> findByUsername(String username);
}
