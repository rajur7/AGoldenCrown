package com.tameofthrones.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class InputReader {

    private static final String INPUT_SEPERATOR = ",";
    private BufferedReader reader;

    public InputReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Map<String, String> getKingdomsWithMessages() throws IOException {
        Map<String, String> kingdomsWithMessages = new LinkedHashMap<>();
        System.out.println("Just press the \'Enter\' key if you want to stop giving input\n" +
                "Input Messages to kingdoms from King Shan:");
        updateWithInputs(kingdomsWithMessages);
        return kingdomsWithMessages;
    }

    private void updateWithInputs(Map<String, String> kingdomsWithMessages) throws IOException {
        String input;
        do {
            System.out.print("Input: ");
            input = reader.readLine();
            if (input.isEmpty()) {
                continue;
            }
            String[] separatedInputs = input.split(INPUT_SEPERATOR);
            kingdomsWithMessages.put(separatedInputs[0], separatedInputs[1]);
        } while (!input.isEmpty());
    }
}
