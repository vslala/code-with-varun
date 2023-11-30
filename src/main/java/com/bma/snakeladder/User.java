package com.bma.snakeladder;

import lombok.Data;

@Data
public class User {

    private final String username;
    private BoardCell position = BoardCell.zeroCell(BoardCell.Type.SIMPLE);

    public User(String username) {
        this.username = username;
    }

    public int rollDice(Dice dice) {
        return dice.roll();
    }

}
