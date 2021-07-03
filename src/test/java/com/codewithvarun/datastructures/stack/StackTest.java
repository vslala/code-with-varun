package com.codewithvarun.datastructures.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    void setup() {
        stack = new Stack<>();
    }

    @Test
    void itShouldPushItemToTheTopOfTheStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.size());
    }

    @Test
    void itShouldPeekAtTheTopItem() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(5, stack.peek());
    }

    @Test
    void itShouldPopTheTopItemFromTheStack() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.pop();
        stack.pop();
        stack.pop();

        assertEquals(2, stack.peek());
    }

    @AfterEach
    void cleanup() {
        stack = null;
    }

}