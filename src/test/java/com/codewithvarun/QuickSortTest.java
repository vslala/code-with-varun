package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void itShouldSortTheGivenArrayInAscendingOrder() {
        var testArr = new int[] {34,1,2,9,8,63,83};
        var quickSort = new QuickSort(testArr);
        var sortedArray = quickSort.sort();
        quickSort.print();
        quickSort.time();

        IntStream.range(0, sortedArray.length - 1).forEach(index ->
                assertTrue(sortedArray[index] < sortedArray[index + 1]));
    }

}