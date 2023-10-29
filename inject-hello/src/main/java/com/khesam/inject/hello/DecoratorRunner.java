package com.khesam.inject.hello;


import com.khesam.inject.hello.service.Salutation;
import com.khesam.inject.hello.util.HashUtil;
import com.khesam.inject.hello.writer.MessageWriter;
import com.khesam.inject.hello.writer.impl.ConsoleMessageWriter;
import com.khesam.inject.hello.writer.impl.ConsoleSecureMessageWriter;

import java.security.NoSuchAlgorithmException;

public class DecoratorRunner {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageWriter messageWriter = new ConsoleSecureMessageWriter(
                new ConsoleMessageWriter(),
                new HashUtil()
        );
        Salutation salutation = new Salutation(messageWriter);
        salutation.say();
    }
}
