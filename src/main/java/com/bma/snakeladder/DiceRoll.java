package com.bma.snakeladder;

public record DiceRoll(
        User user,
        Integer diceOutcome,
        Integer currentPosition,
        Integer nextPosition
) {
}
