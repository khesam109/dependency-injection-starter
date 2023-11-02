package com.khesam.atm.simulator.writer;

import com.khesam.atm.simulator.command.model.CommandResult;

public interface Writer {

    void output(String command, CommandResult result);
}
