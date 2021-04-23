package com.codewithvarun.snakeandladder;

public class Player {
    private final String name;
    private Position currentPos;
    private int lastRoll;

    public Player(String name) {
        this.name = name;
        this.currentPos = new Position(1);
    }

    public Position getPosition() {
        return currentPos;
    }

    public void rollDice(Dice dice) {
        lastRoll = dice.roll();
    }

    public void move() {
        var prevPosition = currentPos;
        currentPos = new Position(currentPos.get() + lastRoll);

        if (currentPos.get() > 100)
            currentPos = prevPosition;
        if (currentPos.get() == 100)
            throw new GameOverException("Player " + name + " won the game!!!");
    }

    public void moveTo(int pos) {
        currentPos = new Position(pos);
    }

    public int lastRoll() {
        return lastRoll;
    }

    public String name() {
        return name;
    }
}
