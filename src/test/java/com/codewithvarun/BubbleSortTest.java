package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    public void itShouldSortTheGivenArrayInAscendingOrder() {

        int[] testArr = {23,0,4,2,8,6};
        var bubbleSort=  new BubbleSort(testArr);
        bubbleSort.sort();
        bubbleSort.print();
        bubbleSort.time();

        IntStream.range(0, testArr.length - 1).forEach(index ->
                assertTrue(testArr[index] < testArr[index + 1]));
    }

}