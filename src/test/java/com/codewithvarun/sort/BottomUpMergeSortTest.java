package com.codewithvarun.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        var arr = new int[]{886,716,787,36,925,731,881,642,540};

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