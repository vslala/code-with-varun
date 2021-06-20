package com.codewithvarun.sort;

import java.util.Arrays;

public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        var arr = Arrays.copyOf(input, input.length);
        var lastIndex = arr.length - 1;
        while (lastIndex > -1) {
            var max = 0;
            for (int j = 1; j <= lastIndex; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }

            swap(arr, lastIndex, max);
            lastIndex --;
        }

        return arr;
    }
}
