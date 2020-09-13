package com.codewithvarun;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

public class Performance {

    private int[] testArr = new int[100000];
    {
        IntStream.range(0, 100000).forEach(index -> {
            testArr[index] = index + 1;
        });
    }

    private CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
    private CustomArrayList<Integer> arrayList = new CustomArrayList<>();

    public void checkPerformance() {
        timer(() -> Arrays.stream(testArr).forEach(item -> arrayList.add(item)), "ADD for array list");
        timer(() -> Arrays.stream(testArr).forEach(item -> linkedList.add(item)), "ADD for linked list");
        timer(() -> Arrays.stream(testArr).forEach(item -> arrayList.get(item)), "GET for array list");
        timer(() -> Arrays.stream(testArr).forEach(item -> linkedList.get(item)), "GET for linked list");
        timer(() -> Arrays.stream(testArr).forEach(item -> arrayList.remove(item)), "REMOVE for array list");
        timer(() -> Arrays.stream(testArr).forEach(item -> linkedList.remove(item)), "REMOVE for linked list");
    }

    public void timer(Runnable job, String msg) {
        long startMillis = currentTimeMillis();
        job.run();
        long totalTimeTaken = currentTimeMillis() - startMillis;

        out.println(msg + ": " +  totalTimeTaken);
    }
}
