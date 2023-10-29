package com.khesam.inject.hello.service;


import com.khesam.inject.hello.writer.MessageWriter;

/**
 * The main logic of the application is encapsulated in the Salutation class
 */
public class Salutation {

    private final MessageWriter messageWriter;

    /**
     * The Salutation class depends on a custom interface called MessageWriter.
     * It requests an instance of it through its constructor.
     */
    public Salutation(MessageWriter messageWriter) {
        if (messageWriter == null) {
            throw new IllegalArgumentException("MessageWriter shall not be null");
        }
        this.messageWriter = messageWriter;
    }

    public void say() {
        this.messageWriter.writeMessage(
                "Salam Asghar"
        );
    }
}
