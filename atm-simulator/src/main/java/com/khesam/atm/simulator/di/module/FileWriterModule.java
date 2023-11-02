package com.khesam.atm.simulator.di.module;

import com.khesam.atm.simulator.writer.Writer;
import com.khesam.atm.simulator.writer.impl.FileWriter;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class FileWriterModule {

    @Binds
    abstract Writer fileWriter(FileWriter writer);
}
