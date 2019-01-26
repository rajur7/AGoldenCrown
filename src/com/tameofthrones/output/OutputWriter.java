package com.tameofthrones.output;

import com.tameofthrones.model.Ruler;

public class OutputWriter {
    public void write(Ruler ruler) {
        System.out.println("\nWho is the ruler of Southeros?");
        System.out.println("Output: " + ruler.getName());
        System.out.println("Allies of Ruler?");
        String allies = String.join(", ", ruler.getAllies());
        System.out.println("Output: " + allies + "\n");
    }
}
