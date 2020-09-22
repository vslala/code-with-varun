package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    public void itShouldSortTheGivenArrayInTheAscendingOrder() {
        int[] testArr = {23,0,4,2,8,6};
        var selectionSort = new SelectionSort(testArr);
        selectionSort.sort();
        selectionSort.print();
        selectionSort.time();

        IntStream.range(0, testArr.length - 1).forEach(index ->
                assertTrue(testArr[index] < testArr[index + 1]));
    }

}