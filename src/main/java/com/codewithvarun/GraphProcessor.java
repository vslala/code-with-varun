package com.codewithvarun;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GraphProcessor implements Processor {


    @Override
    public Integer degree(Graph graph, Integer vertex) {
        AtomicInteger degree = new AtomicInteger();
        graph.adj(vertex).forEach(adjVertex -> degree.getAndIncrement());
        return degree.intValue();
    }

    @Override
    public Integer maxDegree(Graph graph) {
        var maxDegree = new AtomicInteger();
        IntStream.range(0, graph.vertices()).forEach(vertex  -> {
            if (degree(graph, vertex) > maxDegree.intValue()) {
                maxDegree.set(degree(graph, vertex));
            }
        });

        return maxDegree.intValue();
    }

    @Override
    public Double averageDegree(Graph graph) {
        return 2.0 * graph.vertices() / graph.edges();
    }

    @Override
    public Integer numberOfSelfLoops(Graph graph) {
        var numOfSelfLoops = new AtomicInteger();
        IntStream.range(0, graph.vertices()).forEach(vertex -> {
            graph.adj(vertex).forEach(adjVertex -> {
                if (adjVertex == vertex)
                    numOfSelfLoops.getAndIncrement();
            });
        });

        return numOfSelfLoops.intValue();
    }
}
