package com.codewithvarun.snakeandladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PlasticDiceTest {

    private Dice dice = new PlasticDice();

    @Test
    void itShouldAlwaysRollANumberBetween0And7() {
        for (int i = 0; i < 1000; i++) {
            int count = dice.roll();
            assertTrue(count > 0 && count < 7);
        }

    }

}