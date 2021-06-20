package com.codewithvarun.sort;

import java.util.Arrays;

public class InsertionSort implements Sort {


    @Override
    public int[] sort(int[] input) {
        var arr = Arrays.copyOf(input, input.length);

        for (var i = 1; i < arr.length; i++) {
            for (var j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }

        return arr;
    }

}
