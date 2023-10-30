package com.khesam.atm.simulator;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class SystemOutModule {

    /**
     * A @Provides method works a lot like an @Inject constructor:
     * here it tells Dagger that when it needs an instance of Outputter,
     * it should call SystemOutModule.textOutputter() to get one.
     */
    @Provides
    static Outputter textOutputter() {
        return System.out::println;
    }
}
