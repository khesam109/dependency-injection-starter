package com.khesam.inject.hello.writer.impl;


import com.khesam.inject.hello.util.RespectUtils;
import com.khesam.inject.hello.writer.MessageWriter;
import com.khesam.inject.hello.writer.interceptor.MessageWriterInterceptor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InterceptedConsoleMessageWrite implements MessageWriter, MessageWriterInterceptor {

    private static final Logger LOG = Logger.getLogger("InterceptedConsoleMessageWrite");
    private final MessageWriter messageWriter;
    private final RespectUtils respectUtils;

    public InterceptedConsoleMessageWrite(
            MessageWriter messageWriter,
            RespectUtils respectUtils
    ) {
        this.messageWriter = messageWriter;
        this.respectUtils = respectUtils;
    }

    @Override
    public void writeMessage(String message) {
        String before = before(message);
        Void around = around(before);
        Void after = after(around);
    }


    @Override
    public String before(String i) {
        LOG.log(Level.INFO, "Beginning execution of before. The input is: " + i);
        String processedI = this.respectUtils.addRespect(i);
        LOG.log(Level.INFO, "Ending execution of before. The input is: " + processedI);

        return processedI;
    }

    @Override
    public Void around(String i) {
        LOG.log(Level.INFO, "Beginning execution of around");
        this.messageWriter.writeMessage(
                i
        );
        LOG.log(Level.INFO, "Ending execution of around");

        return null;
    }

    @Override
    public Void after(Void o) {
        LOG.log(Level.INFO, "Beginning execution of after");
        LOG.log(Level.INFO, "Ending execution of after");

        return null;
    }
}
