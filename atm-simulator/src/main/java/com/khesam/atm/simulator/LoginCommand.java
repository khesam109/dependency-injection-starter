package com.khesam.atm.simulator;

import javax.inject.Inject;

class LoginCommand extends SingleArgCommand {

    private final Outputter outputter;
    private final Database database;

    @Inject
    public LoginCommand(
            Outputter outputter,
            Database database
    ) {
        this.outputter = outputter;
        this.database = database;
    }

    @Override
    protected Result handleArg(String username) {
        Database.Account account = database.getAccount(username);
        outputter.output(
                username + " is logged in with balance: " + account.balance()
        );
        return Result.handled();
    }
}
