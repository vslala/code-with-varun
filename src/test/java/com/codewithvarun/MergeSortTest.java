package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeSortTest {

    @Test
    public void itShouldSortTheGivenArrayInTheAscendingOrder() {
        int[] testArr = {4,3,1,2,5};
        var mergeSort = new MergeSort(testArr);
        int[] output = mergeSort.sort();
        mergeSort.print();
        mergeSort.time();

        IntStream.range(0, output.length - 1).forEach(index ->
                assertTrue(output[index] < output[index + 1]));
    }

}