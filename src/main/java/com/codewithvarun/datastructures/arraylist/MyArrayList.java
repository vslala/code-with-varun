package com.codewithvarun.datastructures.arraylist;

import java.util.Arrays;

public class MyArrayList<T> {

    private static final int DEFAULT_SIZE = 2;
    private int size = 0;
    private Object[] arr;

    public MyArrayList() {
        arr = new Object[DEFAULT_SIZE];
    }

    public void add(T item) {
        if (size + 1 > arr.length) {
            // grow
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[size++] = item;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public void removeIndex(int index) {
        for (var i = index + 1; i < size; i++)
            arr[i - 1] = arr[i];

        size--;
    }

    public void remove(T item) {
        for (var index =  0; index < size; index++) {
            if (item.equals(arr[index])) {
                removeIndex(index);
                break;
            }
        }
    }
}
