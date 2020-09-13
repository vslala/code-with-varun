package com.codewithvarun;

public interface Processor {

    Integer degree(Graph graph, Integer vertex);

    Integer maxDegree(Graph graph);

    Double averageDegree(Graph graph);

    Integer numberOfSelfLoops(Graph graph);
}
