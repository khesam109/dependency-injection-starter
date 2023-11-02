package com.khesam.atm.simulator;


import com.khesam.atm.simulator.di.component.AtmComponent;
import com.khesam.atm.simulator.di.component.ConfigComponent;
import com.khesam.atm.simulator.di.component.DaggerAtmComponent;
import com.khesam.atm.simulator.di.component.DaggerConfigComponent;

public class AtmRunner {

    public static void main(String[] args) {
        ConfigComponent configComponent = DaggerConfigComponent.create();
        AtmComponent atmComponent = DaggerAtmComponent.builder()
                .currency(
                        configComponent.atmConfig().atmCurrency()
                ).build();

        atmComponent.atm().start();
    }
}
