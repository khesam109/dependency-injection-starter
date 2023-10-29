package com.khesam.atm.simulator;

import dagger.Component;

/**
 * CommandRouterFactory is a normal factory type for CommandRouters.
 * Its implementation would call new CommandRouter() instead of our main method doing it.
 * But instead of us writing the implementation of CommandRouterFactory,
 * we can annotate it with @Component to have Dagger generate an implementation for us: DaggerCommandRouterFactory.
 * Note that it has a static create() method to give us an instance to use.
 * This could be abstract or interface
 */
@Component
interface CommandRouterFactory {

    CommandRouter router();
}
