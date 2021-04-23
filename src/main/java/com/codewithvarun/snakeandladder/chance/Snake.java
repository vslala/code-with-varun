package com.codewithvarun.snakeandladder.chance;

public class Snake {
    private int head = 0;
    private int tail = 0;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }

    public int tail() {
        return tail;
    }

    public int head() {
        return head;
    }
}
