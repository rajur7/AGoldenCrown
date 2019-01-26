package com.tameofthrones.model;

public class Kingdom {
    final private String name;
    final private String emblem;

    public Kingdom(String name, String emblem) {
        this.name = name;
        this.emblem = emblem;
    }

    public String getName() {
        return name;
    }

    public String getEmblem() {
        return emblem;
    }
}
