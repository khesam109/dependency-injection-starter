package com.khesam.inject.hello;

import com.khesam.inject.hello.service.Salutation;
import com.khesam.inject.hello.writer.MessageWriter;
import com.khesam.inject.hello.writer.impl.ConsoleMessageWriter;

/**
 * basic example of Pure DI. No DI Container!
 * The Main method creates new instances of both the ConsoleMessageWriter and Salutation classes.
 * <p>
 * You could easily solve the same problem as shown here by: System.out.println(message);
 * <p>
 * In this example, DI adds an overhead of 500% if we count the lines of code
 */
public class Runner {

    public static void main(String[] args) {
        MessageWriter messageWriter = new ConsoleMessageWriter();
        Salutation salutation = new Salutation(
                messageWriter
        );

        salutation.say();
    }
}
