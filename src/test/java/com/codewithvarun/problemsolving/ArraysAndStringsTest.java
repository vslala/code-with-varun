package com.codewithvarun.problemsolving;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArraysAndStringsTest {

    private ArraysAndStrings testClass;

    @BeforeEach
    void setUp() {
        testClass = new ArraysAndStrings();
    }

    @Test
    void itShouldDetermineIfTheInputStringContainsAllUniqueCharacters() {
        var testInputs = Map.of(
                "abcde", true,
                "varun", true,
                "shrivastava", false
        );
        testInputs.forEach((input, expectedOutput) -> assertEquals(expectedOutput, testClass.determineIfInputHasAllUniqueCharacters(input)));
    }

    @Test
    void itShouldDetermineIfTheInputStringContainsAllUniqueCharactersOptimized() {
        var testInputs = Map.of(
                "abcde", true,
                "varun", true,
                "shrivastava", false
        );
        testInputs.forEach((input, expectedOutput) -> assertEquals(expectedOutput, testClass.determineIfInputHasAllUniqueCharactersOptimized(input)));
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }
}