package com.codewithvarun;

public class MergeSort implements Sort {

    private int[] input;
    private long totalTime;

    public MergeSort(int[] input) {
        this.input = input;
    }

    @Override
    public int[] sort() {
        long startMillis = System.currentTimeMillis();
        int[] sortedArr = divide(input);
        totalTime = System.currentTimeMillis() - startMillis;
        return sortedArr;
    }

    private int[] divide(int[] arr) {
        // recursive call breaker
        if (arr.length <= 1) return arr;

        // break the array into two parts
        // 6,5,4,3,2,1
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[0 == arr.length % 2 ? mid : mid + 1];

        // populate the left array
        for (int i=0; i < left.length; i++) left[i] = arr[i];

        // populate the right array
        for (int i = 0; i < right.length; i++) right[i] = arr[i + mid];

        // sort the left recursively
        left = divide(left);
        // sort the right recursively
        right = divide(right);
        // merge both left and right
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {

        // iterate over left and right array and store the minimum value in the new array
        int[] output = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int currentPointer = 0;

        while (true)
            if (leftPointer < left.length && rightPointer < right.length)
                if (left[leftPointer] < right[rightPointer]) output[currentPointer++] = left[leftPointer++];
                else output[currentPointer++] = right[rightPointer++];
            else if (leftPointer < left.length) output[currentPointer++] = left[leftPointer++];
            else if (rightPointer < right.length) output[currentPointer++] = right[rightPointer++];
            else break;

        return output;
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
