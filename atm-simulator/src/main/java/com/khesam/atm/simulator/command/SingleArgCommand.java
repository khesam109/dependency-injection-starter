package com.khesam.atm.simulator.command;

import com.khesam.atm.simulator.command.model.CommandResult;

import java.util.List;

public abstract class SingleArgCommand implements Command {

    @Override
    public CommandResult execute(List<String> args) {
        if (args != null && args.size() == 1) {
            return execute(args.get(0));
        }

        return CommandResult.invalid("Invalid Arguments for Single command");
    }

    protected abstract CommandResult execute(String arg);
}
