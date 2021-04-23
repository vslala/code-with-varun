package com.codewithvarun.snakeandladder.chance;

public class Ladder {
    private int head;
    private int tail;

    public Ladder(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int head() {
        return head;
    }

    public int tail() {
        return tail;
    }
}
