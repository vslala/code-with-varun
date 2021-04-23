package com.codewithvarun.snakeandladder;

public class FakeDice implements Dice {

    private int fakeRoll = 0;

    public void setNextRoll(int nextRoll) {
        this.fakeRoll = nextRoll;
    }

    @Override
    public int roll() {
        return this.fakeRoll;
    }
}
