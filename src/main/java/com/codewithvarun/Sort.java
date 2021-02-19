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

    long totalTime();

    static long bubbleSort(int[] input) {
        BubbleSort bubbleSort = new BubbleSort(input);
        bubbleSort.sort();
        return bubbleSort.totalTime();
    }

    static long mergeSort(int input[]) {
        MergeSort mergeSort = new MergeSort(input);
        mergeSort.sort();
        return mergeSort.totalTime();
    }

    static long quickSort(int input[]) {
        QuickSort quickSort = new QuickSort(input);
        quickSort.sort();
        return quickSort.totalTime();
    }

    static long insertionSort(int input[]) {
        InsertionSort insertionSort = new InsertionSort(input);
        insertionSort.sort();
        return insertionSort.totalTime();
    }

    static long shellSort(int input[]) {
        ShellSort shellSort = new ShellSort(input);
        shellSort.sort();
        return shellSort.totalTime();
    }

    static long selectionSort(int input[]) {
        SelectionSort selectionSort = new SelectionSort(input);
        selectionSort.sort();
        return selectionSort.totalTime();
    }
}
