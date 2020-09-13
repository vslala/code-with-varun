package com.codewithvarun;

import java.util.Objects;

class Node<T> {
    T item;
    Node<T> next;

    public Node(T item) {
        this.item = item;
    }
}

public class CustomLinkedList<T> implements CustomList<T> {

    Node<T> head;
    Node<T> lastNode;

    @Override
    public void add(T item) {
        if (Objects.isNull(head)) {
            head = new Node<>(item);
            lastNode = head;
        }
        else {
            var newNode = new Node<>(item);
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    @Override
    public void remove(int index) {
        int counter = 0;
        Node<T> itr = head;
        Node<T> prev = head;
        while (! Objects.isNull(itr.next) && counter < index) {
            prev = itr;
            itr = itr.next;
            counter++;
        }

        prev.next = itr.next;
    }

    @Override
    public T get(int index) {
        int i = 0;
        Node<T> itr = head;
        while (!Objects.isNull(itr.next) &&  i < index) {
            itr = itr.next;
            i++;
        }
        return itr.item;
    }
}
