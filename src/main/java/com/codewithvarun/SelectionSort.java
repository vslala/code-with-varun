package com.codewithvarun;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SelectionSort implements Sort {

    private final int[] input;
    private long totalTime = 0;

    public SelectionSort(int[] input) {
        this.input = input;
    }

    @Override
    public int[] sort() {
        long startMillis = System.currentTimeMillis();
        AtomicInteger min = new AtomicInteger();
        IntStream.range(0, input.length).forEach(sortedIndex -> {
            min.set(input[sortedIndex]);
            IntStream.range(sortedIndex, input.length).forEach(rightIndex -> {
                print();
                if (input[rightIndex] < min.intValue()) {
                    min.set(input[rightIndex]);
                    input[rightIndex] = input[sortedIndex];
                    input[sortedIndex] = min.intValue();
                }
            });
        });
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
