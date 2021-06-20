package com.codewithvarun.sort;

public class SelectionSort {

    public int[] sort(int[] arr) {
        var lastIndex = arr.length - 1;
        while (lastIndex > -1) {
            var max = 0;
            for (int j = 1; j <= lastIndex; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }

            var temp = arr[lastIndex];
            arr[lastIndex] = arr[max];
            arr[max] = temp;

            lastIndex --;
        }

        return arr;
    }
}
