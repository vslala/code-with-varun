package com.codewithvarun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayListTest {

    CustomList<Integer> arrayList = new CustomArrayList<>();

    @Test
    public void itShouldAddElementToTheList() {
        fillArray();

        assertEquals(50, arrayList.get(22));
        assertEquals(60, arrayList.get(23));
    }

    private void fillArray() {
        for (int i=0; i<50; i++) {
            arrayList.add(i+1);
        }
    }

    @Test
    public void itShouldRemoveTheElementFromTheGivenIndex() {
        fillArray();

        arrayList.remove(26);

        assertEquals(50, arrayList.get(48));
        assertEquals(28, arrayList.get(26));
    }

}