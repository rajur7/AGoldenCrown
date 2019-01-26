package com.tameofthrones;

import com.tameofthrones.input.InputReader;
import com.tameofthrones.output.OutputWriter;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        RulersManager rulersManager = new RulersManager(inputReader, outputWriter);
        rulersManager.start();
    }
}
