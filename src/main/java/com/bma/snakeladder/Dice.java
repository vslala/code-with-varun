package com.bma.snakeladder;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Dice {

    public int roll() {
        return ThreadLocalRandom.current().nextInt(1, 7);
    }
}
