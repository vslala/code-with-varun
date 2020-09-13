package com.codewithvarun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomLinkedListTest {

    private CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

    private void fillArray() {
        for (int i=0; i<50; i++) {
            linkedList.add(i+1);
        }
    }

    @Test
    public void itShouldAddElementToTheList() {
        fillArray();

        assertEquals(50, linkedList.get(49));
        assertEquals(5, linkedList.get(4));
    }

    @Test
    public void itShouldRemoveItemFromTheList() {
        fillArray();

        linkedList.remove(26);

        assertEquals(50, linkedList.get(48));
        assertEquals(28, linkedList.get(26));
    }

}