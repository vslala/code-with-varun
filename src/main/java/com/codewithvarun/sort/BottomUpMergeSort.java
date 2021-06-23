package com.codewithvarun.sort;

import java.util.Arrays;

public class BottomUpMergeSort implements  Sort {
    @Override
    public int[] sort(int[] input) {
        var arr = Arrays.copyOf(input, input.length);
        var aux = new int[input.length];
        for (var width = 1; width < arr.length; width = 2 * width) {
            int i;
            for (i = 0; i < arr.length; i = i + 2 * width) {
                int left = i;   // start index of array 1
                int middle = i + width; // start index of second array or the end index of first array
                int end = i + 2 * width;    // end of the second array

                merge(arr, left, middle, end, aux);
            }
            for (i = 0; i < arr.length; i++) {
                arr[i] = aux[i];
            }
        }
        return arr;
    }

    private void merge(int[] arr, int left, int middle, int end, int[] aux) {
        int i = left;
        int j = middle;
        int k = left;

        while (i < middle || j < end) {
            if (i < middle && j < end) {
                if (arr[i] < arr[j]) aux[k++] = arr[i++];
                else aux[k++] = arr[j++];
            }

            else if (i == middle) aux[k++] = arr[j++];
            else if (j == end) aux[k++] = arr[i++];
        }
    }
}
