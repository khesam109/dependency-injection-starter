package com.khesam.atm.simulator.di.module;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Module
public abstract class ApplicationPropertiesModule {

    private static final String FILE_NAME = "application.properties";

    @Provides
    @Singleton
    static Properties provideApplicationProperties() {
        Properties properties = new Properties();
        try (InputStream is = ApplicationPropertiesModule.class.getClassLoader().getResourceAsStream(FILE_NAME)) {
            properties.load(is);
            return properties;
        } catch (IOException ex) {
            throw new RuntimeException("Failed to read application.properties file due to: ", ex);
        }
    }
}
