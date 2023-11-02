package com.khesam.atm.simulator.command;

import com.khesam.atm.simulator.command.model.CommandResult;

import java.util.List;

public interface Command {

    CommandResult execute(List<String> args);
}
