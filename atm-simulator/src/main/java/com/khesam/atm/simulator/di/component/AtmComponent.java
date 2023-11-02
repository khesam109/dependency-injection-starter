package com.khesam.atm.simulator.di.component;

import com.khesam.atm.simulator.command.model.AtmCurrency;
import com.khesam.atm.simulator.di.module.ConsoleWriterModule;
import com.khesam.atm.simulator.di.module.FileWriterModule;
import com.khesam.atm.simulator.di.module.InMemoryDatabaseModule;
import com.khesam.atm.simulator.di.module.PublicCommandModule;
import com.khesam.atm.simulator.domain.Atm;
import dagger.BindsInstance;
import dagger.Component;

import javax.inject.Singleton;


@Singleton
@Component(modules = {
        ConsoleWriterModule.class,
//        FileWriterModule.class,
        PublicCommandModule.class,
        InMemoryDatabaseModule.class
})
public interface AtmComponent {

    Atm atm();

    @Component.Builder
    interface Builder {

        AtmComponent build();
        @BindsInstance Builder currency(AtmCurrency currency);
    }
}
