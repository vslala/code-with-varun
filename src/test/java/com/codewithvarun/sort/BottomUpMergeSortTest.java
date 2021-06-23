package com.codewithvarun.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BottomUpMergeSortTest {
    private Sort selectionSort;

    // setup
    @BeforeEach
    void setup() {
        selectionSort = new BottomUpMergeSort();
    }

    // test
    @Test
    void itShouldSortTheGivenArrayInAscendingOrder() {
        // given
        var arr = new int[]{34, 12, 34, 7, 3, 23, 65, 23};

        // when
        int[] output = selectionSort.sort(arr);

        // then
        System.out.println(Arrays.stream(output).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        assertEquals(arr.length, output.length);
        IntStream.range(0, output.length - 1).forEach(index -> assertTrue(output[index] <= output[index + 1]));
    }

    // clean
    @AfterEach
    void cleanup() {
        selectionSort = null;
    }
}