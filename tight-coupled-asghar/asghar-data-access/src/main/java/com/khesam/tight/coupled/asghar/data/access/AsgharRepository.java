package com.khesam.tight.coupled.asghar.data.access;

import java.util.Set;

public class AsgharRepository {

    private final Set<Asghar> asghars;

    public AsgharRepository() {
        this.asghars = this.addSomeAsghars();

    }

    public Set<Asghar> findAllAsghars() {
        return this.asghars;
    }

    private Set<Asghar> addSomeAsghars() {
        return Set.of(
                new Asghar("Asghar Davaloo"),
                new Asghar("Asghar Farhadi")
        );
    }
}
