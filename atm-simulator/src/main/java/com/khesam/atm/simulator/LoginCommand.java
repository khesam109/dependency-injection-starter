package com.khesam.atm.simulator;

import javax.inject.Inject;

class LoginCommand extends SingleArgCommand {

    private final Outputter outputter;
    private final Database database;
    private final UserCommandsRouter.Factory userCommandsRouterFactory;

    @Inject
    public LoginCommand(
            Outputter outputter,
            Database database,
            UserCommandsRouter.Factory userCommandsRouterFactory
    ) {
        this.outputter = outputter;
        this.database = database;
        this.userCommandsRouterFactory = userCommandsRouterFactory;
    }

    @Override
    protected Result handleArg(String username) {
        Database.Account account = database.getAccount(username);
        outputter.output(
                username + " is logged in with balance: " + account.balance()
        );
        return Result.enterNestedCommandSet(
                userCommandsRouterFactory.create(account).router()
        );
    }
}
