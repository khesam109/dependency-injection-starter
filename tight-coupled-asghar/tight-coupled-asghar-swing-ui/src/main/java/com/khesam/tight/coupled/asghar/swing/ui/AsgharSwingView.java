package com.khesam.tight.coupled.asghar.swing.ui;

import com.khesam.tight.coupled.asghar.domain.AsgharService;

import javax.swing.*;
import java.util.stream.Collectors;

public class AsgharSwingView {

    private final AsgharService asgharService;

    public AsgharSwingView() {
        this.asgharService = new AsgharService();
    }

    public void showAsghars() {
        JFrame frame = new JFrame("Asghars!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JTextArea jTextArea = new JTextArea(
                this.asgharService.getAllAsghar().stream().map(e -> e.toString() + "\n").collect(Collectors.joining())
        );
        frame.getContentPane().add(jTextArea);
        frame.setVisible(true);
    }
}
