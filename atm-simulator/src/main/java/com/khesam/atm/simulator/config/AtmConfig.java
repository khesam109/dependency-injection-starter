package com.khesam.atm.simulator.config;

import com.khesam.atm.simulator.command.model.AtmCurrency;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.EnumSet;
import java.util.Properties;

@Singleton
public class AtmConfig {

    private static final AtmCurrency DEFAULT_CURRENCY = AtmCurrency.RIAL;
    private static final String ATM_CURRENCY_KEY = "currency";

    private final Properties properties;

    @Inject
    public AtmConfig(Properties properties) {
        this.properties = properties;
    }

    public AtmCurrency atmCurrency() {
        return EnumSet.allOf(
                AtmCurrency.class
        ).stream().filter(
                e -> e.name().equalsIgnoreCase(
                        value(ATM_CURRENCY_KEY)
                )
        ).findAny().orElse(
                DEFAULT_CURRENCY
        );
    }

    private String value(String key) {
        return properties.getProperty(
                key
        );
    }
}
