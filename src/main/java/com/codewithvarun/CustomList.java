package com.codewithvarun;

public interface CustomList<T> {

    void add(T item);
    void remove(int index);
    T get(int index);

}
