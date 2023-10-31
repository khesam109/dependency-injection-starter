package com.khesam.atm.simulator;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Subcomponent;

/**
 * The @Subcomponent annotation defines what modules Dagger should know
 * about when creating instances for this subcomponent only.
 */
@Subcomponent(modules = {
        UserCommandsModule.class
})
interface UserCommandsRouter {

    /**
     * declares what object we want Dagger to create
     */
    CommandRouter router();

    @Subcomponent.Factory
    interface Factory {
        UserCommandsRouter create(
                @BindsInstance Database.Account account
        );
    }

    @Module(subcomponents = UserCommandsRouter.class)
    interface InstallationModule {}
}
