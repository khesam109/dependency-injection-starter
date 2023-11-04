package com.khesam.tight.coupled.asghar.runner;



import com.khesam.tight.coupled.asghar.console.ui.AsgharConsoleView;
import com.khesam.tight.coupled.asghar.swing.ui.AsgharSwingView;

public class Runner {

    public static void main(String[] args) {

//        AsgharConsoleView asgharConsoleView = new AsgharConsoleView();
//        asgharConsoleView.showAsghars();

        AsgharSwingView asgharSwingView = new AsgharSwingView();
        asgharSwingView.showAsghars();
    }
}
