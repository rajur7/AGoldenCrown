package com.tameofthrones.helper;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class EmblemFinder {

    private static final int ONE = 1;

    public boolean find(String emblem, String message) {
        if(isNull(emblem) || isNull(message) || emblem.isEmpty()){
            return false;
        }
        emblem = emblem.toLowerCase();
        message = message.toLowerCase();

        Map<Character, Integer> emblemCharactersFrequency = getFrequencyOfCharacters(emblem);
        Map<Character, Integer> messageCharactersFrequency = getFrequencyOfCharacters(message);

        Integer countOfEmblemCharactersInMessage = getCountOfEmblemCharactersInMessage(emblemCharactersFrequency, messageCharactersFrequency);

        return countOfEmblemCharactersInMessage.equals(emblemCharactersFrequency.size());
    }

    private Map<Character, Integer> getFrequencyOfCharacters(final String characters) {
        Map<Character, Integer> characterFrequency = new HashMap<>();
        for (char character : characters.toCharArray()) {
            characterFrequency.merge(character, ONE, Integer::sum);
        }
        return characterFrequency;
    }

    private Integer getCountOfEmblemCharactersInMessage(Map<Character, Integer> emblemCharactersFrequency,
                                                        Map<Character, Integer> messageCharactersFrequency) {
        final Integer[] countOfMatchedLetters = {0};
        emblemCharactersFrequency.keySet().forEach(character -> {
            Integer characterCountInMessage = messageCharactersFrequency.get(character);
            if (nonNull(characterCountInMessage)
                    && characterCountInMessage >= emblemCharactersFrequency.get(character)) {
                countOfMatchedLetters[0]++;
            }
        });
        return countOfMatchedLetters[0];
    }

}
