package com.khesam.atm.simulator.writer;

import com.khesam.atm.simulator.command.model.CommandResult;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CommandResultFormatter {

    @Inject
    public CommandResultFormatter() {
    }

    public String format(String command, CommandResult result) {
        return "<<<" + command + ">>> " + result;
    }
}
