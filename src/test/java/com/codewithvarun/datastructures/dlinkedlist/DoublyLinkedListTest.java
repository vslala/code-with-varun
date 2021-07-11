package com.codewithvarun.datastructures.dlinkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> doublyLinkedList;
    @BeforeEach
    void setUp() {
        doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addToLast(100);
        doublyLinkedList.addToFront(99);
    }

    @Test
    void itShouldAppendTheItemAtTheEndOfTheList() {
        doublyLinkedList.addToLast(100);
        assertEquals(3, doublyLinkedList.size());
    }

    @Test
    void itShouldAppendAtTheFrontOfTheList() {
        // When
        DNode<Integer> front = doublyLinkedList.front();

        // Then
        assertEquals(2, doublyLinkedList.size());
        assertEquals(99, front.getData());
        assertEquals(100, front.getNext().getData());
    }

    @Test
    void itShouldReturnTheNodePrevToTheGivenNode() {
        assertEquals(99, doublyLinkedList.prev(100, 0));
    }

    @Test
    void itShouldRemoveTheNodeFromTheList() {
        doublyLinkedList.remove(99);
        assertEquals(100, doublyLinkedList.front().getData());
    }

    @AfterEach
    void tearDown() {
        doublyLinkedList = null;
    }
}