package com.khesam.atm.simulator.command.impl;

import com.khesam.atm.simulator.command.SingleArgCommand;
import com.khesam.atm.simulator.command.model.CommandResult;
import com.khesam.atm.simulator.repository.Database;
import com.khesam.atm.simulator.repository.entity.Account;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class LoginCommand extends SingleArgCommand {

    private final Database database;

    @Inject
    public LoginCommand(Database database) {
        this.database = database;
    }

    @Override
    protected CommandResult execute(String arg) {
        Optional<Account> account = database.findByUsername(arg);
        if (account.isEmpty()) {
            return CommandResult.failed("Invalid username!!");
        }

        return CommandResult.success(account.toString());
    }
}
