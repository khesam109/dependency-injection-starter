package com.khesam.inject.hello.writer.impl;


import com.khesam.inject.hello.writer.MessageWriter;

public class ConsoleUpperCaseMessageWriter implements MessageWriter {

    @Override
    public void writeMessage(String message) {
        System.out.println(
                message.toUpperCase()
        );
    }
}
