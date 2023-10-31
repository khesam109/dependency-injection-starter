package com.khesam.atm.simulator;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        LoginCommandModule.class,
        HelloWorldModule.class,
        UserCommandsRouter.InstallationModule.class,
        SystemOutModule.class
})
interface CommandProcessorFactory {

    CommandProcessor commandProcessor();
}
