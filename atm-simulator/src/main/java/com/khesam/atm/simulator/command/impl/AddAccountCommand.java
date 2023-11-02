package com.khesam.atm.simulator.command.impl;

import com.khesam.atm.simulator.command.SingleArgCommand;
import com.khesam.atm.simulator.command.model.CommandResult;
import com.khesam.atm.simulator.repository.Database;
import com.khesam.atm.simulator.repository.entity.Account;

import javax.inject.Inject;

public class AddAccountCommand extends SingleArgCommand {

    private final Database database;

    @Inject
    public AddAccountCommand(Database database) {
        this.database = database;
    }

    @Override
    protected CommandResult execute(String arg) {
        this.database.insert(
                new Account(arg)
        );
        return CommandResult.success(
                String.format("%s's account created", arg)
        );
    }
}
