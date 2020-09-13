package com.codewithvarun;

public class CustomArrayList<T> implements CustomList<T> {

    private static final int DEFAULT_CAPACITY = 5;
    private int currIndex = 0;
    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private int size = 0;

    @Override
    public void add(T item) {
        if (size >= elements.length) {
            growArray();
        }
        elements[currIndex++] = item;
        size++;
    }

    private void growArray() {
        var biggerArr = new Object[size * 2];
        for (int i = 0; i < elements.length; i++) {
            biggerArr[i] = elements[i];
        }
        elements = biggerArr;
    }

    @Override
    public void remove(int index) {
        for (int i=index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        currIndex--;
    }

    @Override
    public T get(int index) {
        return (T) elements[index];
    }
}
