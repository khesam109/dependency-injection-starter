package com.khesam.inject.hello.writer.impl;


import com.khesam.inject.hello.util.HashUtil;
import com.khesam.inject.hello.writer.MessageWriter;

/**
 * Secure ConsoleMessageWriter by hashing the message
 * <p>
 * Notice that you wrap or decorate the old ConsoleMessageWriter instance with the new
 * ConsoleSecureMessageWriter class. Once more, the Salutation class is unmodified because
 * it only consumes the MessageWriter interface. Similarly, there’s no need to either
 * modify or duplicate the functionality in the ConsoleMessageWriter class, either.
 */
public class ConsoleSecureMessageWriter implements MessageWriter {

    private final MessageWriter messageWriter;
    private final HashUtil hashUtil;

    public ConsoleSecureMessageWriter(
            MessageWriter messageWriter,
            HashUtil hashUtil
    ) {
        this.messageWriter = messageWriter;
        this.hashUtil = hashUtil;
    }

    @Override
    public void writeMessage(String message) {
        this.messageWriter.writeMessage(
                this.hashUtil.doHash(
                        message
                )
        );
    }
}
