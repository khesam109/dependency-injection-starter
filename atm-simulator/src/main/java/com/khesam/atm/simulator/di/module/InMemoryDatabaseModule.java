package com.khesam.atm.simulator.di.module;

import com.khesam.atm.simulator.repository.Database;
import com.khesam.atm.simulator.repository.impl.InMemoryDatabase;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class InMemoryDatabaseModule {

    @Binds
    abstract Database inMemoryDatabase(InMemoryDatabase database);
}
