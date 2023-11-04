package com.khesam.atm.simulator.domain;

import com.khesam.atm.simulator.command.Command;
import com.khesam.atm.simulator.command.model.CommandResult;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Singleton
public class CommandProcessor {

    private final Map<String, Command> publicCommands;

    @Inject
    public CommandProcessor(
            Map<String, Command> publicCommands
    ) {
        this.publicCommands = publicCommands;
    }

    public CommandResult process(String input) {
        List<String> splitInput = split(input);

        if (splitInput.isEmpty()) {
            return CommandResult.invalid("Command not found!");
        }

        return process(
                splitInput.get(0),
                splitInput.subList(1, splitInput.size())
        );
    }

    private CommandResult process(String commandKey, List<String> args) {
        Optional<Command> command = getCommand(commandKey);
        if (command.isEmpty()) {
            return CommandResult.invalid("Command not found!");
        }
        return command.get().execute(args);
    }

    private List<String> split(String input) {
        return Arrays.asList(input.trim().split("\\s+"));
    }

    private Optional<Command> getCommand(String command) {
        return Optional.ofNullable(
                publicCommands.get(command)
        );
    }
}
