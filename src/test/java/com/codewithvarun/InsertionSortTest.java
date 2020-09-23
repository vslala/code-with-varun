package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    public void itShouldTakeTheUnsortedArrayAndSortTheArrayInAscendingOrder() {
        int [] testArr = {5,2,3,1,6,77,0};
        var insertionSort = new InsertionSort(testArr);
        insertionSort.sort();

        IntStream.range(0, testArr.length - 1).forEach(index ->
                assertTrue(testArr[index] < testArr[index + 1]));
    }

}