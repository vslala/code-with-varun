package com.codewithvarun;

public class InsertionSort implements Sort {

    private int[] input;
    private long totalTime = 0;

    public InsertionSort(int[] input) {
        this.input = input;
    }

    @Override
    public int[] sort() {
        long startMillis = System.currentTimeMillis();
        for (int i=0; i < input.length; i++) {
            for (int j=i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    Sort.swap(input, j, j - 1);
                } else break;
            }
        }
        totalTime = System.currentTimeMillis() - startMillis;
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
}
