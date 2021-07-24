package com.codewithvarun.datastructures.arraylist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    void setup() {
        myArrayList = new MyArrayList<>();
        myArrayList.add(100);
        myArrayList.add(101);
        myArrayList.add(102);
        myArrayList.add(103);
        myArrayList.add(104);
    }

    @Test
    void itShouldAddNewItemToTheArrayList() {
        assertEquals(5, myArrayList.size());
    }

    @Test
    void itShouldGetTheElementByIndex() {
        assertEquals(104, myArrayList.get(4));
    }

    @Test
    void itShouldRemoveItemByIndex() {
        myArrayList.removeIndex(2);
        assertEquals(4, myArrayList.size());
        assertEquals(100, myArrayList.get(0));
        assertEquals(101, myArrayList.get(1));
        assertEquals(103, myArrayList.get(2));
        assertEquals(104, myArrayList.get(3));
    }

    @Test
    void itShouldRemoveItemByValue() {
        myArrayList.remove(102);
        assertEquals(4, myArrayList.size());
        assertEquals(100, myArrayList.get(0));
        assertEquals(101, myArrayList.get(1));
        assertEquals(103, myArrayList.get(2));
        assertEquals(104, myArrayList.get(3));
    }

    @AfterEach
    void cleanup() {
        myArrayList = null;
    }
}