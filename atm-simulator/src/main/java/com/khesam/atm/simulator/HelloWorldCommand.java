package com.khesam.atm.simulator;

import javax.inject.Inject;
import java.util.List;

/**
 * Dagger knows how to create a HelloWorldCommand because it has an @Inject constructor
 */
final class HelloWorldCommand implements Command {

    @Inject
    public HelloWorldCommand() {
    }

    @Override
    public String key() {
        return "hello";
    }

    @Override
    public Result handleInput(List<String> input) {
        if (!input.isEmpty()) {
            return Result.invalid();
        }

        System.out.println("world!");
        return Result.handled();
    }
}
