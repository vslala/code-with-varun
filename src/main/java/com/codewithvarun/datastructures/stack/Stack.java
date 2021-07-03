package com.codewithvarun.datastructures.stack;

public class Stack<T> {

    private Node<T> topNode;
    private int size = 0;

    public void push(T item) {
        if (size == 0) {
            topNode = new Node<>(item, null);
        } else {
            var newNode  = new Node<>(item, topNode);
            topNode = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T peek() {
        return topNode.getValue();
    }

    public void pop() {
        topNode = topNode.getNext();
    }
}
