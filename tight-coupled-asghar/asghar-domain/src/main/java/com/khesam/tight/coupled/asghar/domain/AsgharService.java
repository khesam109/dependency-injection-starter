package com.khesam.tight.coupled.asghar.domain;

import com.khesam.tight.coupled.asghar.data.access.Asghar;
import com.khesam.tight.coupled.asghar.data.access.AsgharRepository;

import java.util.Set;

public class AsgharService {

    private final AsgharRepository asgharRepository;

    public AsgharService() {
        this.asgharRepository = new AsgharRepository();
    }

    public Set<Asghar> getAllAsghar() {
        return asgharRepository.findAllAsghars();
    }
}
