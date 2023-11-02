package com.khesam.atm.simulator.command;

import com.khesam.atm.simulator.command.model.CommandResult;

import java.math.BigDecimal;
import java.util.Optional;

public abstract class FinancialCommand extends SingleArgCommand {

    @Override
    protected CommandResult execute(String arg) {
        Optional<BigDecimal> amount = parse(arg);
        if (amount.isEmpty()) {
            return CommandResult.invalid("Invalid amount!!");
        }

        return execute(amount.get());
    }

    protected abstract CommandResult execute(BigDecimal amount);

    private Optional<BigDecimal> parse(String arg) {
        try {
            return Optional.of(new BigDecimal(arg));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }
}
