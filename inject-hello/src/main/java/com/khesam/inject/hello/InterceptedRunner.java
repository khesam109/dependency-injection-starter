package com.khesam.inject.hello;

import com.khesam.inject.hello.service.Salutation;
import com.khesam.inject.hello.util.RespectUtils;
import com.khesam.inject.hello.writer.MessageWriter;
import com.khesam.inject.hello.writer.impl.ConsoleMessageWriter;
import com.khesam.inject.hello.writer.impl.InterceptedConsoleMessageWrite;

public class InterceptedRunner {

    public static void main(String[] args) {
        MessageWriter messageWriter = new InterceptedConsoleMessageWrite(
                new ConsoleMessageWriter(),
                new RespectUtils()
        );
        Salutation salutation = new Salutation(
                messageWriter
        );

        salutation.say();
    }
}
