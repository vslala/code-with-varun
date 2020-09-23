package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @Test
    public void itShouldSortTheGivenArrayInTheAscendingOrder() {
        int[] testArr = {4,3,1,2,5};
        var shellSort = new ShellSort(testArr);
        shellSort.sort();
        shellSort.print();
        shellSort.time();

        IntStream.range(0, testArr.length - 1).forEach(index ->
                assertTrue(testArr[index] < testArr[index + 1]));
    }

}