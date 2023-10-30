package com.khesam.atm.simulator;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Singleton
class Database {

    private final Map<String, Account> accounts = new HashMap<>();

    @Inject
    public Database() {
    }

    Account getAccount(String username) {
        return accounts.computeIfAbsent(username, Account::new);
    }

    static final class Account {

        private final String username;
        private BigDecimal balance = BigDecimal.ZERO;

        public Account(String username) {
            this.username = username;
        }

        String username() {
            return username;
        }

        BigDecimal balance() {
            return balance;
        }

        void deposit(BigDecimal amount) {
            balance = balance.add(amount);
        }
    }
}
