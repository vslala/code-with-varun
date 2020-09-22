package com.codewithvarun;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.Collectors.joining;

public class BubbleSort implements Sort {


    private final int[] input;
    private long totalTime = 0L;

    public BubbleSort(int[] input) {
        this.input =  input;
    }

    public void sort() {
        long startMillis = System.currentTimeMillis();
        IntStream.range(0, input.length)
                .forEach(outer ->
                        IntStream.range(0, input.length - 1)
                                .forEach(this::swap));
        totalTime = System.currentTimeMillis() - startMillis;
    }

    @Override
    public void print() {
        print(input);
    }

    @Override
    public void time() {
        time(totalTime);
    }

    private void swap(int innerIndex) {
        if (input[innerIndex + 1] < input[innerIndex]) {
            int swap  = input[innerIndex];
            input[innerIndex] = input[innerIndex +  1];
            input[innerIndex + 1] = swap;
        }
    }
}
