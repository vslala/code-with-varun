package com.codewithvarun.datastructures.linkedlist;

import com.codewithvarun.datastructures.Node;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListTest {

    private MyLinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
    }

    @Test
    void itShouldAppendNewItemAtTheEnd() {
        assertEquals(5, linkedList.size());
    }

    @Test
    void itShouldRemoveItemFromTheList() {
        var index = 3;
        linkedList.removeIndex(index);
        Node<Integer> firstNode = linkedList.firstNode();

        assertEquals(4, linkedList.size());
        assertEquals(1, firstNode.getValue());
        assertEquals(2, firstNode.getNext().getValue());
        assertEquals(3, firstNode.getNext().getNext().getValue());
        assertEquals(5, firstNode.getNext().getNext().getNext().getValue());
    }

    @Test
    void itShouldGetTheValueByIndex() {
        var index = 3;
        var result = linkedList.get(index);
        assertEquals(4, result);
    }

    @Test
    void itShouldRemoveItemByValue() {
        var item = 2;

        linkedList.remove(item);

        var firstNode = linkedList.firstNode();

        assertEquals(4, linkedList.size());
        assertEquals(1, firstNode.getValue());
        assertEquals(3, firstNode.getNext().getValue());
    }

    @AfterEach
    void tearDown() {
        linkedList = null;
    }
}