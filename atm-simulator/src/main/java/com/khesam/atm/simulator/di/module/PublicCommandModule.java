package com.khesam.atm.simulator.di.module;

import com.khesam.atm.simulator.command.Command;
import com.khesam.atm.simulator.command.impl.AddAccountCommand;
import com.khesam.atm.simulator.command.impl.LoginCommand;
import com.khesam.atm.simulator.command.impl.PingCommand;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public abstract class PublicCommandModule {

    @Binds
    @IntoMap
    @StringKey("ping")
    abstract Command pingCommand(PingCommand command);

    @Binds
    @IntoMap
    @StringKey("add")
    abstract Command addAccountCommand(AddAccountCommand command);

    @Binds
    @IntoMap
    @StringKey("login")
    abstract Command loginCommand(LoginCommand command);
}
