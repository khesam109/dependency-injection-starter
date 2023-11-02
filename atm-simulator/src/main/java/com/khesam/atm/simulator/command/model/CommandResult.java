package com.khesam.atm.simulator.command.model;

public final class CommandResult {

    private final ResultStatus resultStatus;
    private final String resultMessage;

    private CommandResult(ResultStatus resultStatus, String resultMessage) {
        this.resultStatus = resultStatus;
        this.resultMessage = resultMessage;
    }

    public static CommandResult invalid(String message) {
        return new CommandResult(
                ResultStatus.INVALID,
                message
        );
    }

    public static CommandResult failed(String message) {
        return new CommandResult(
                ResultStatus.FAILED,
                message
        );
    }

    public static CommandResult success(String message) {
        return new CommandResult(
                ResultStatus.SUCCESS,
                message
        );
    }

    public ResultStatus resultStatus() {
        return resultStatus;
    }

    public String resultMessage() {
        return resultMessage;
    }

    @Override
    public String toString() {
        return "Status=" + resultStatus +
                ", resultMessage='" + resultMessage + '\'';
    }
}
