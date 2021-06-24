package com.codewithvarun.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort implements Sort {

    private final Random rand = new Random();

    @Override
    public int[] sort(int[] input) {
        var arr = Arrays.copyOf(input, input.length);
        var start = 0;
        var end = input.length;
        quickSort(arr, start, end);
        return arr;
    }

    private void quickSort(int[] arr, int start, int end) {
        if (start == end)
            return;

        // choose a pivot
        var randomPivotIndex = rand.nextInt(end - start) + start;

        // push this random pivot to the end of my array
        swap(arr, randomPivotIndex, end - 1);
        randomPivotIndex = end - 1;

        var i = start;
        var j = i;
        while (j < randomPivotIndex - 1) {
            if (arr[j] < arr[randomPivotIndex]) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }

        // ith will become the pivot
        swap(arr, i, randomPivotIndex);
        randomPivotIndex = i;

        quickSort(arr, start, randomPivotIndex);
        quickSort(arr, randomPivotIndex + 1, end);
    }
}
