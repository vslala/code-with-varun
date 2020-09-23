package com.codewithvarun;

public class ShellSort implements Sort {

    private int[] input;
    private long totalTime = 0;

    public ShellSort(int[] input) {
        this.input = input;
    }

    @Override
    public int[] sort() {
        long startMillis = System.currentTimeMillis();
        int gap = 1;
        // N/3
        var builder = new StringBuilder();
        while (gap < input.length / 3) {
            builder.append(gap).append(",");
            gap = 3 * gap + 1;
        }

        System.out.println(builder.toString());

        while (gap > 1) {
            for (int i = gap; i < input.length; i++) {
                for (int j = i; j >= gap && input[j] < input[j - gap]; j -= gap) {
                    Sort.swap(input, j, j - gap);
                }
            }

            gap = gap / 3;
        }

        var insertionSort = new InsertionSort(input);
        insertionSort.sort();
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
