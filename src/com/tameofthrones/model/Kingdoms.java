package com.tameofthrones.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Kingdoms {

    private final List<Kingdom> kingdoms = Arrays.asList(
            new Kingdom("land", "panda"),
            new Kingdom("water", "octopus"),
            new Kingdom("ice", "mammoth"),
            new Kingdom("air", "owl"),
            new Kingdom("fire", "dragon"));

    public Optional<Kingdom> getKingdomEmblem(final String kingdomName) {
        return kingdoms.stream().filter(kingdom -> kingdomName.equalsIgnoreCase(kingdom.getName())).findFirst();
    }
}
