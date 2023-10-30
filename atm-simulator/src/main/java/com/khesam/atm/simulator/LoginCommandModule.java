package com.khesam.atm.simulator;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class LoginCommandModule {

    /**
     * The @StringKey annotation, combined with @IntoMap, tells Dagger how to populate a Map<String, Command>.
     *
     * @IntoMap and @IntoSet are both ways of introducing what is often called “multi-bindings”,
     * where a collection contains elements from several different binding methods.
     */
    @Binds
    @IntoMap
    @StringKey("login")
    abstract Command loginCommand(LoginCommand command);
}
