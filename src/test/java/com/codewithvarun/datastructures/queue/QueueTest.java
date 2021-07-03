package com.codewithvarun.datastructures.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueTest {


    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
    }

    @Test
    void itShouldPushItemToTheQueueAndIncrementTheSize() {
        assertEquals(5, queue.size());
    }

    @Test
    void itShouldPeekTheFirstItemInTheQueue() {
        assertEquals(1, queue.peek());
    }

    @Test
    void itShouldDequeItemFromTheQueue() {
        queue.deque();
        queue.deque();
        queue.deque();
        queue.deque();

        assertEquals(5, queue.peek());
        assertEquals(1, queue.size());
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }
}