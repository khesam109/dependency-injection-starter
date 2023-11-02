package com.khesam.atm.simulator.domain;

import com.khesam.atm.simulator.command.model.AtmCurrency;
import com.khesam.atm.simulator.writer.Writer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Scanner;

@Singleton
public class Atm {

    private final CommandProcessor commandProcessor;
    private final Writer writer;
    private final AtmCurrency currency;
    private final Scanner scanner;

    @Inject
    public Atm(
            CommandProcessor commandProcessor,
            Writer writer,
            AtmCurrency currency
    ) {
        this.commandProcessor = commandProcessor;
        this.writer = writer;
        this.currency = currency;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Currency: " + currency);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();

            writer.output(input, commandProcessor.process(input));
        }
    }
}
