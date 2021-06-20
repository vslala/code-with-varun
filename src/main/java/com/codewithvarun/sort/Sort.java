package com.codewithvarun.sort;

public interface Sort {
    int[] sort(int[] input);

    default void swap(int[] arr, int i, int j) {
        var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
