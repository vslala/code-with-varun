package com.codewithvarun.datastructures.dlinkedlist;

import java.util.Objects;

public class DoublyLinkedList<T> {

    private DNode<T> firstNode;
    private DNode<T> lastNode;
    private int size;

    public void addToLast(T item) {
        var newNode = new DNode<T>(null, item, null);

        if (size == 0) {
            lastNode = newNode;
            firstNode = newNode;
        } else {
            newNode.setPrev(lastNode); // lastNode is the lastNode
            lastNode.setNext(newNode);
            lastNode = newNode;
        }

        size++;
    }

    public int size() {
        return size;
    }

    public void addToFront(T item) {
        var newNode = new DNode<T>(null, item, null);

        if (size == 0) {
            lastNode = newNode;
        } else {
            newNode.setNext(firstNode); // this is the first node
            firstNode.setPrev(newNode);
        }
        firstNode = newNode;
        size++;
    }

    public DNode<T> front() {
        return firstNode;
    }

    public T prev(T item, T defaultVal) {
        var temp = firstNode;

        while (temp != null) {
            if (temp.getData().equals(item))
                return temp.getPrev().getData();
            temp = temp.getNext();
        }

        return defaultVal;
    }

    public void remove(T item) {
        var temp = firstNode;

        if (firstNode.getData().equals(item)) {
            firstNode = firstNode.getNext();
            return;
        }

        if (lastNode.getData().equals(item)) {
            lastNode = lastNode.getPrev();
            return;
        }

        while (temp != null) {
            if (temp.getData().equals(item))
            {
                var nodeToDelete = temp;
                var nodePrev = nodeToDelete.getPrev();
                var nodeAfter = nodeToDelete.getNext();

                nodeAfter.setPrev(nodePrev);
                nodePrev.setNext(nodeAfter);

                break;
            }
            temp = temp.getNext();
        }
    }
}
