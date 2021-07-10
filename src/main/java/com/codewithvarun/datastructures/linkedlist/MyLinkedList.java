package com.codewithvarun.datastructures.linkedlist;

import com.codewithvarun.datastructures.Node;

public class MyLinkedList<T> {

    private Node<T> lastNode;
    private Node<T> firstNode;
    private int size;

    public void add(T item) {
        if (size == 0) {
            lastNode = new Node<>(item, null);
            firstNode = lastNode;
        } else {
            var temp = lastNode;
            lastNode = new Node<>(item, null);
            temp.setNext(lastNode);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(T item) {
        var temp = firstNode;
        while(temp.getNext() != null) {
            if (temp.getNext().getValue().equals(item))
                temp.setNext(temp.getNext().getNext());

            temp = temp.getNext();
        }
        size--;
    }

    public void removeIndex(int index) {
        // remove the item
        var temp = firstNode;
        for (var i = 0; i < index - 1; i++)
            temp = temp.getNext();

        temp.setNext(temp.getNext().getNext());
        size--;
    }

    public Node<T> firstNode() {
        return firstNode;
    }

    public T get(int index) {
        var temp = firstNode;
        for (var i = 0; i < index; i++)
            temp = temp.getNext();

        return temp.getValue();
    }
}
