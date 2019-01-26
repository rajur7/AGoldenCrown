package com.tameofthrones.helper;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmblemFinderTest {

    private EmblemFinder emblemFinder = new EmblemFinder();

    @Test
    public void shouldReturnTrueWhenMessageContainEmblem() {
        assertTrue(emblemFinder.find("Panda", "MessageWithPanda"));
    }

    @Test
    public void shouldReturnFalseWhenMessageDoesNotContainEmblem() {
        assertFalse(emblemFinder.find("Panda", "MessageWithoutEmblem"));
    }

    @Test
    public void shouldFindEmblemInTheMessageAndReturnTrueIrrespectiveOfCaseSensitiveOfMessageAndEmblem() {
        assertTrue(emblemFinder.find("panda", "MessageWithoutPanda"));
    }

    @Test
    public void shouldReturnTrueWhenEmblemCharactersAllAreInMessageInAnyOrder() {
        assertTrue(emblemFinder.find("Mammoth", "Ahoy! Fight for me with men and money"));
    }

    @Test
    public void shouldReturnFalseWhenEmblemCharactersAllAreNotInMessageInAnyOrder() {
        assertFalse(emblemFinder.find("panda", "1d22n333a4444p"));
    }

    @Test
    public void shouldReturnFalseWhenEmblemIsNull() {
        assertFalse(emblemFinder.find(null, "message"));
    }

    @Test
    public void shouldReturnFalseWhenMessageIsNull() {
        assertFalse(emblemFinder.find("dragon", null));
    }

    @Test
    public void shouldReturnFalseWhenEmblemIsEmpty() {
        assertFalse(emblemFinder.find("", "message"));
    }


    @Test
    public void shouldReturnFalseWhenMessageIsEmpty() {
        assertFalse(emblemFinder.find("dragon", ""));
    }
}
