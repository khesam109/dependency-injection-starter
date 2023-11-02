package com.khesam.atm.simulator.di.module;

import com.khesam.atm.simulator.writer.Writer;
import com.khesam.atm.simulator.writer.impl.ConsoleWriter;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ConsoleWriterModule {

    @Binds
    abstract Writer consoleWriter(ConsoleWriter writer);
}
