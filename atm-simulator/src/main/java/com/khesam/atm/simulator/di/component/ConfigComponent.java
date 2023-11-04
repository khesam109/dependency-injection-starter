package com.khesam.atm.simulator.di.component;

import com.khesam.atm.simulator.config.AtmConfig;
import com.khesam.atm.simulator.di.module.ApplicationPropertiesModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
        ApplicationPropertiesModule.class
})
public interface ConfigComponent {

    AtmConfig atmConfig();
}
