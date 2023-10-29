package com.khesam.inject.hello;

import com.khesam.inject.hello.service.Salutation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageWriterTest {

    @Test
    void test() {
        SpyMessageWriter messageWriter = new SpyMessageWriter();
        Salutation salutation = new Salutation(
                messageWriter
        );
        salutation.say();

        Assertions.assertEquals(
                "Salam Asghar",
                messageWriter.getMessage()
        );
    }
}
