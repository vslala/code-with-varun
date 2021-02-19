package com.codewithvarun;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class BubbleSort implements Sort {


    private final int[] input;
    private long totalTime = 0L;

    public BubbleSort(int[] input) {
        this.input =  input;
    }

    public int[] sort() {
        long startMillis = System.currentTimeMillis();
        IntStream.range(0, input.length)
                .forEach(outer ->
                        IntStream.range(0, input.length - 1)
                                .forEach(this::swap));
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

    @Override
    public long totalTime() {
        return totalTime;
    }

    private void swap(int innerIndex) {
        if (input[innerIndex + 1] < input[innerIndex]) {
            Sort.swap(input, innerIndex, innerIndex + 1);
        }
    }
}
