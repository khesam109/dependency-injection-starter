package com.khesam.inject.hello;


import com.khesam.inject.hello.service.Salutation;
import com.khesam.inject.hello.writer.MessageWriter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Loose coupling enables late binding because there’s only a single place where
 * you create the instance of MessageWriter. Because the Salutation class works
 * exclusively against the MessageWriter interface, it never notices the difference.
 */
public class LateBindingRunner {

    public static void main(String[] args) {
        MessageWriter messageWriter = getWriter();
        Salutation salutation = new Salutation(messageWriter);
        salutation.say();
    }

    private static MessageWriter getWriter() {
        try {
            Class<?> clazz = Class.forName(
                    loadWriterClassFromResources()
            );
            return (MessageWriter) clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static String loadWriterClassFromResources() {
        Properties properties = new Properties();
        try (InputStream is = LateBindingRunner.class.getClassLoader().getResourceAsStream(
                "application.properties")
        ) {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty("message-writer");
    }
}
