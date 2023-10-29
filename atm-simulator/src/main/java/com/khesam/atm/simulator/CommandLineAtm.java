package com.khesam.atm.simulator;

import java.util.Scanner;

public class CommandLineAtm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CommandRouterFactory commandRouterFactory = DaggerCommandRouterFactory.create();
        CommandRouter commandRouter = commandRouterFactory.router();

        while (scanner.hasNext()) {
            Command.Status status = commandRouter.rout(scanner.nextLine()).status();
        }
    }
}
