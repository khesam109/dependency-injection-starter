package com.khesam.inject.hello;


import com.khesam.inject.hello.writer.MessageWriter;

public class SpyMessageWriter implements MessageWriter {

    private String message;

    @Override
    public void writeMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
