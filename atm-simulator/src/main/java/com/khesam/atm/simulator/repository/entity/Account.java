package com.khesam.atm.simulator.repository.entity;

import java.math.BigDecimal;

public final class Account {

    private final String username;
    private BigDecimal balance;

    public Account(String username) {
        this.username = username;
        this.balance = BigDecimal.ZERO;
    }

    public String username() {
        return username;
    }

    public BigDecimal balance() {
        return balance;
    }

    void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", balance=" + balance;
    }
}
