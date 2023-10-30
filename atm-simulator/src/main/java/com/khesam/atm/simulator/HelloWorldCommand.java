package com.khesam.atm.simulator;

import javax.inject.Inject;
import java.util.List;

/**
 * Dagger knows how to create a HelloWorldCommand because it has an @Inject constructor
 */
final class HelloWorldCommand implements Command {

    private final Outputter outputter;

    @Inject
    public HelloWorldCommand(
            Outputter outputter
    ) {
        this.outputter = outputter;
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }

        outputter.output("world!");
        return Result.handled();
    }
}
