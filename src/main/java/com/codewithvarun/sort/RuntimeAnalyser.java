package com.codewithvarun.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RuntimeAnalyser {
    private final List<Sort> algorithms;
    private final Random rand = new Random();
    private int arrayLength;
    public <E> RuntimeAnalyser(List<Sort> algorithms, int arrayLength) {
        this.algorithms = algorithms;
        this.arrayLength = arrayLength;
    }

    public List<Record> run() {
        return algorithms.stream().map(algo -> new Record(algo.getClass().getName(), Timer.timeIt(() -> {
            algo.sort(generateRandomArr(arrayLength));
        }))).collect(Collectors.toList());
    }

    private int[] generateRandomArr(int size) {
        return IntStream.range(0, size)
                .mapToObj(index -> rand.nextInt(1000))
                .mapToInt(i -> i).toArray();
    }
}
