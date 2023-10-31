package com.khesam.atm.simulator;

import java.util.List;
import java.util.Optional;

/**
 * Logic to process some user input.
 */
interface Command {

    /**
     * Process the rest of the command's words and do something.
     */
    Result handleInput(List<String> input);

    /**
     * This wrapper class is introduced to make a future change easier
     * even though it looks unnecessary right now.
     */
    final class Result {

        private final Status status;
        private final Optional<CommandRouter> nestedCommandRouter;

        private Result(
                Status status,
                Optional<CommandRouter> nestedCommandRouter
        ) {
            this.status = status;
            this.nestedCommandRouter = nestedCommandRouter;
        }

        static Result invalid() {
            return new Result(Status.INVALID, Optional.empty());
        }

        static Result handled() {
            return new Result(Status.HANDLED, Optional.empty());
        }

        Status status() {
            return this.status;
        }

        Optional<CommandRouter> nestedCommandRouter() {
            return nestedCommandRouter;
        }

        static Result enterNestedCommandSet(CommandRouter nestedCommandRouter) {
            return new Result(Status.HANDLED, Optional.of(nestedCommandRouter));
        }
    }

    enum Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
