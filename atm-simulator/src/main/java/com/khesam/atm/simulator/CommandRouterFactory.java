package com.khesam.atm.simulator;

import dagger.Component;

import javax.inject.Singleton;

/**
 * CommandRouterFactory is a normal factory type for CommandRouters.
 * Its implementation would call new CommandRouter() instead of our main method doing it.
 * But instead of us writing the implementation of CommandRouterFactory,
 * we can annotate it with @Component to have Dagger generate an implementation for us: DaggerCommandRouterFactory.
 * Note that it has a static create() method to give us an instance to use.
 * This could be abstract or interface
 *
 * To tell Dagger to look for that @Binds method in HelloWorldModule, we add it to the @Component annotation.
 *
 * Consider that, if you want to change HelloWorldCommand with LoginCommand, just need replace the corresponding
 * module in component!
 */
@Singleton
@Component(modules = {
        HelloWorldModule.class,
        LoginCommandModule.class,
        UserCommandsModule.class,
        SystemOutModule.class
})
interface CommandRouterFactory {

    CommandRouter router();
}
