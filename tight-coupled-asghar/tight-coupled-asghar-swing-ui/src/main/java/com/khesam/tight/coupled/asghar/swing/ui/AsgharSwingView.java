package com.khesam.tight.coupled.asghar.swing.ui;

import javax.swing.*;

public class AsgharSwingView {

    public void showAsghars() {
        JFrame frame = new JFrame("Asghars!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JTextArea jTextArea = new JTextArea("salam");
        frame.getContentPane().add(jTextArea);
        frame.setVisible(true);
    }
}
