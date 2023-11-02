package com.khesam.atm.simulator.repository.impl;

import com.khesam.atm.simulator.repository.Database;
import com.khesam.atm.simulator.repository.entity.Account;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Singleton
public class InMemoryDatabase implements Database {

    private final Map<String, Account> accounts;

    @Inject
    public InMemoryDatabase() {
        this.accounts = new HashMap<>();
    }

    @Override
    public void insert(Account account) {
        this.accounts.put(account.username(), account);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return Optional.ofNullable(
                this.accounts.get(username)
        );
    }
}
