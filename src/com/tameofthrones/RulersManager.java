package com.tameofthrones;

import com.tameofthrones.helper.UniverseOfSoutheros;
import com.tameofthrones.input.InputReader;
import com.tameofthrones.model.Ruler;
import com.tameofthrones.output.OutputWriter;

import java.io.IOException;
import java.util.Map;

public class RulersManager {
    private static final String NONE = "None";
    private final InputReader inputReader;
    private final OutputWriter outputWriter;
    private final UniverseOfSoutheros universeOfSoutheros;
    private final Ruler defaultRuler;

    public RulersManager(InputReader inputReader, OutputWriter outputWriter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        universeOfSoutheros = new UniverseOfSoutheros();
        defaultRuler = new Ruler(NONE);
        defaultRuler.addAlly(NONE);
    }

    public void start() throws IOException {
        outputWriter.write(defaultRuler);
        Map<String, String> kingdomsWithMessages = inputReader.getKingdomsWithMessages();
        Ruler ruler = new Ruler("King Shan");
        universeOfSoutheros.updateRulerWithAllies(ruler, kingdomsWithMessages);
        if (ruler.getAllies().size() >= 3) {
            outputWriter.write(ruler);
        } else {
            outputWriter.write(defaultRuler);
        }
    }
}
