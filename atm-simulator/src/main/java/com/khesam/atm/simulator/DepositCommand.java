package com.khesam.atm.simulator;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

class DepositCommand extends BigDecimalCommand {

    private final Database.Account account;

    @Inject
    DepositCommand(
            Database.Account account,
            Outputter outputter
    ) {
        super(outputter);
        this.account = account;
    }

    @Override
    protected void handleAmount(BigDecimal amount) {
        account.deposit(amount);
        super.outputter.output(account.username() + " now has: " + account.balance());
    }
}
