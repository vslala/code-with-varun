package com.codewithvarun;

import java.util.Arrays;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

public interface Sort {

    default void print(int[] input) {
        String sortedArray = Arrays.stream(input).mapToObj(String::valueOf).collect(joining(","));
        out.println(sortedArray);
    }

    default void time(long totalTime) {
        out.println("Total time taken: " + totalTime + "ms");
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp =  arr[index1];
        arr[index1] = arr[index2];
        arr[index2] =  temp;
    }

    int[] sort();

    void print();

    void time();
}
