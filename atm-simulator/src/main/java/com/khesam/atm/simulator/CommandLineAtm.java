package com.khesam.atm.simulator;



import java.util.Scanner;

public class CommandLineAtm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CommandProcessorFactory commandProcessorFactory = DaggerCommandProcessorFactory.create();
        CommandProcessor commandProcessor = commandProcessorFactory.commandProcessor();

        while (scanner.hasNextLine()) {
            Command.Status unused = commandProcessor.process(scanner.nextLine());
        }
    }
}
