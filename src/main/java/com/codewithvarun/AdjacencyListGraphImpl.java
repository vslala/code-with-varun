package com.codewithvarun;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Bag {

    private Set<Integer> list;

    Bag() {
        this.list = new HashSet<>();
    }

    public void add(Integer vertex) {
        this.list.add(vertex);
    }

    public Iterable<Integer> get() {
        return this.list;
    }
}

public class AdjacencyListGraphImpl implements Graph {

    private Bag[] vertices;

    public AdjacencyListGraphImpl(int vertices) {
        this.vertices = new Bag[vertices];
        IntStream.range(0, vertices).forEach(vertex -> {
            this.vertices[vertex] = new Bag();
        });
    }

    @Override
    public void addEdge(Integer vertex1, Integer vertex2) {
        vertices[vertex1].add(vertex2);
        vertices[vertex2].add(vertex1);
    }

    @Override
    public Iterable<Integer> adj(Integer vertex) {
        return vertices[vertex].get();
    }

    @Override
    public Integer vertices() {
        return vertices.length;
    }

    @Override
    public Integer edges() {
        AtomicInteger edges = new AtomicInteger();
        IntStream.range(0, vertices()).forEach(vertex ->  {
            for (Integer w : adj(vertex)) {
                edges.getAndIncrement();
            }
        });

        return edges.intValue() / 2;
    }
}
