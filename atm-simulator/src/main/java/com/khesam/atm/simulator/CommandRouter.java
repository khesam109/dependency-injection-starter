package com.khesam.atm.simulator;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * collect multiple Commands and route input strings to them based on the first word in the input
 */
final class CommandRouter {

    private final Map<String, Command> commands = new HashMap<>();

    /**
     * In order for Dagger to know how to create a CommandRouter,
     * we need to add an @Inject annotation to its constructor.
     * The @Inject annotation indicates to Dagger that when we ask for a CommandRouter,
     * Dagger should call new CommandRouter().
     */
    @Inject
    public CommandRouter(
            HelloWorldCommand helloWorldCommand
    ) {
        commands.put(helloWorldCommand.key(), helloWorldCommand);
    }

    Command.Result rout(String input) {
        List<String> splitInput = split(input);
        if (splitInput.isEmpty()) {
            return invalidCommand(input);
        }

        String commandKey = splitInput.get(0);
        Command command = commands.get(commandKey);

        if (command == null) {
            return invalidCommand(input);
        }

        List<String> args = splitInput.subList(1, splitInput.size());
        Command.Result result = command.handleInput(args);

        return result.status().equals(Command.Status.INVALID) ?
                invalidCommand(input) : result;
    }

    private Command.Result invalidCommand(String input) {
        System.out.printf("couldn't understand \"%s\". please try again.%n", input);

        return Command.Result.invalid();
    }

    // Split on whitespace
    private static List<String> split(String input) {
        return Arrays.asList(input.trim().split("\\s+"));
    }
}
