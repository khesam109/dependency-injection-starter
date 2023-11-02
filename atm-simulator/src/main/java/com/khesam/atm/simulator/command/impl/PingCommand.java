package com.khesam.atm.simulator.command.impl;

import com.khesam.atm.simulator.command.ZeroArgCommand;
import com.khesam.atm.simulator.command.model.CommandResult;

import javax.inject.Inject;

public class PingCommand extends ZeroArgCommand {

    @Inject
    public PingCommand() {
    }

    @Override
    protected CommandResult execute() {
        return CommandResult.success("Pong");
    }
}
