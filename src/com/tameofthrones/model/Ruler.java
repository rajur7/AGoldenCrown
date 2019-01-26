package com.tameofthrones.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Ruler {

    final private String name;
    private Set<String> allies;

    public Ruler(final String name) {
        this.name = name;
        this.allies = new LinkedHashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public Set<String> getAllies() {
        return this.allies;
    }

    public void addAlly(String kingdomName) {
        this.allies.add(kingdomName);
    }
}
