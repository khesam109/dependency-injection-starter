package com.khesam.tight.coupled.asghar.console.ui;

import com.khesam.tight.coupled.asghar.domain.AsgharService;

public class AsgharConsoleView {

    private final AsgharService asgharService;

    public AsgharConsoleView() {
        this.asgharService = new AsgharService();
    }

    public void showAsghars() {
        asgharService.getAllAsghar().forEach(
                System.out::println
        );
    }
}
