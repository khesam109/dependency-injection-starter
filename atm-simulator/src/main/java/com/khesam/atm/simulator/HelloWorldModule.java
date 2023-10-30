package com.khesam.atm.simulator;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
abstract class HelloWorldModule {

    /**
     * @Binds methods are one way to tell Dagger how to construct an instance.
     * They are abstract methods on modules that associate one type that Dagger
     * already knows how to construct (the method’s parameter) with a type that
     * Dagger does not yet know how to construct (the method’s return type).
     */
    @Binds
    @IntoMap
    @StringKey("hello")
    abstract Command helloWorldCommand(HelloWorldCommand command);
}
