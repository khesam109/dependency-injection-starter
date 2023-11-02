package com.khesam.atm.simulator.writer.impl;

import com.khesam.atm.simulator.command.model.CommandResult;
import com.khesam.atm.simulator.writer.CommandResultFormatter;
import com.khesam.atm.simulator.writer.Writer;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ConsoleWriter implements Writer {

    private final CommandResultFormatter commandResultFormatter;

    @Inject
    public ConsoleWriter(
            CommandResultFormatter commandResultFormatter
    ) {
        this.commandResultFormatter = commandResultFormatter;
    }

    @Override
    public void output(String command, CommandResult result) {
        System.out.println(
                commandResultFormatter.format(command, result)
        );
    }
}
