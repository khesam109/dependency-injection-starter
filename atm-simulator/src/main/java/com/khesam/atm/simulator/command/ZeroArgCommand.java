package com.khesam.atm.simulator.command;

import com.khesam.atm.simulator.command.model.CommandResult;

import java.util.List;

public abstract class ZeroArgCommand implements Command {

    @Override
    public CommandResult execute(List<String> args) {
        if (args == null || args.isEmpty()) {
            return execute();
        }

        return CommandResult.invalid("Invalid Arguments for Zero command");
    }

    protected abstract CommandResult execute();
}
