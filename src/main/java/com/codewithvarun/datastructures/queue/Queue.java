package com.codewithvarun.datastructures.queue;

import com.codewithvarun.datastructures.Node;

public class Queue<T> {

    private int size;
    private Node<T> first;
    private Node<T> curr;

    public void enque(T item) {
        if (size == 0) {
            first = new Node<>(item, null);
            curr = first;
        } else {
            var newNode = new Node<>(item, curr);
            curr.setNext(newNode);
            curr = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return first.getValue();
    }

    public void deque() {
        first = first.getNext();
        size--;
    }
}
