package com.codewithvarun;

import java.util.Random;

public class QuickSort implements Sort {

    private int[] input;
    private Random rand;
    private long totalTime = 0;

    public QuickSort(int[] input) {
        this.input = input;
        rand = new Random();
    }

    @Override
    public int[] sort() {
        long startMillis = System.currentTimeMillis();
        var output = quickSort(input, 0, input.length);
        totalTime = System.currentTimeMillis() - startMillis;

        return output;
    }

    private int[] quickSort(int[] input, int start, int end) {

        // recursive terminator
        if (start == end) return input;

        // pick a random pivot
        int randomNumber = rand.nextInt(end - start);
        int randomPivot = randomNumber + start;

        // push the pivot at the end of the array
        Sort.swap(input, randomPivot, end - 1);
        int pivot = end - 1;

        // sort the array
        int i = start;
        int j = start;
        while (j < pivot) {
            if (input[j] < input[pivot]) {
                Sort.swap(input, i, j);
                i++;
            }
            j++;
        }
        Sort.swap(input, i, pivot);
        pivot = i;

        // recursively sort the left side of the pivot
        quickSort(input, start, pivot);

        // recursively sort the right side of the pivot
        quickSort(input, pivot + 1, end);

        return input;
    }

    @Override
    public void print() {
        print(input);
    }

    @Override
    public void time() {
        time(totalTime);
    }

    @Override
    public long totalTime() {
        return totalTime;
    }
}
