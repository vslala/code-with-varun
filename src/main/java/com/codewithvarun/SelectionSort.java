package com.codewithvarun;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.stream.Collectors.*;

public class SelectionSort implements Sort {

    private final int[] input;
    private long totalTime = 0;

    public SelectionSort(int[] input) {
        this.input = input;
    }

    @Override
    public void sort() {
        long startMillis = System.currentTimeMillis();
        AtomicInteger min = new AtomicInteger();
        IntStream.range(0, input.length).forEach(sortedIndex -> {
            min.set(input[sortedIndex]);
            IntStream.range(sortedIndex, input.length).forEach(rightIndex -> {
                if (input[rightIndex] < min.intValue()) {
                    min.set(input[rightIndex]);
                    input[rightIndex] = input[sortedIndex];
                    input[sortedIndex] = min.intValue();
                }
            });
        });
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
}
