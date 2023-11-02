package com.khesam.atm.simulator.writer.impl;

import com.khesam.atm.simulator.command.model.CommandResult;
import com.khesam.atm.simulator.writer.CommandResultFormatter;
import com.khesam.atm.simulator.writer.Writer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.BufferedWriter;
import java.io.IOException;

@Singleton
public class FileWriter implements Writer {

    private static final String FILE_NAME = "command.logs";

    private final BufferedWriter writer;
    private final CommandResultFormatter commandResultFormatter;

    @Inject
    public FileWriter(
            CommandResultFormatter commandResultFormatter
    ) {
        this.commandResultFormatter = commandResultFormatter;

        try {
            this.writer = new BufferedWriter(
                    new java.io.FileWriter(
                            FILE_NAME
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void output(String command, CommandResult result) {
        try {
            writer.write(
                    commandResultFormatter.format(
                            command, result
                    )
            );
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
