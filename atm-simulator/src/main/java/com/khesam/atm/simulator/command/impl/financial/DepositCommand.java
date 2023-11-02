package com.khesam.atm.simulator.command.impl.financial;

import com.khesam.atm.simulator.command.FinancialCommand;
import com.khesam.atm.simulator.command.model.CommandResult;

import java.math.BigDecimal;

public class DepositCommand extends FinancialCommand {


    @Override
    protected CommandResult execute(BigDecimal amount) {
        return null;
    }
}
