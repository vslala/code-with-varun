package com.codewithvarun.snakeandladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    private Player player = new Player("A");

    @Test
    void playerShouldMoveTheTokenBasedOnTheDiceRoll() {

        player.rollDice(new PlasticDice());
        Position position = player.getPosition();
        assertTrue(position.get() > 0 && position.get() < 7);
    }

    @Test
    void playerRollsA4AndMovesTheTokenToNewPosition() {
        FakeDice dice = new FakeDice();
        dice.setNextRoll(4);
        player.rollDice(dice);
        assertEquals(5, player.getPosition().get());
    }

}