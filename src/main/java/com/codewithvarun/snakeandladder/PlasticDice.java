package com.codewithvarun.snakeandladder;

import java.util.Random;

public class PlasticDice implements Dice {
    public static final int MAX = 6;
    public static final int MIN = 1;
    @Override
    public int roll() {
        return new Random().nextInt(MAX - MIN + 1) + MIN;
    }
}
