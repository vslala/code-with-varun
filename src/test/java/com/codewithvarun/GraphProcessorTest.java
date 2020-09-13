package com.codewithvarun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphProcessorTest {

    GraphProcessor graphProcessor = new GraphProcessor();
    AdjacencyListGraphImpl graph;

    @BeforeEach
    public void setup() {
        graph = new AdjacencyListGraphImpl(10);
        graph.addEdge(0, 6);
        graph.addEdge(0, 5);
        graph.addEdge(0, 7);
        graph.addEdge(0, 8);
        graph.addEdge(0, 9);
        graph.addEdge(2, 6);
        graph.addEdge(2, 5);
        graph.addEdge(3, 9);
    }

    @Test
    public void itShouldGiveTheDegreeOfTheGivenVertex() {
        assertEquals(5, graphProcessor.degree(graph, 0));
    }

    @Test
    public void itShouldGiveUsTheMaxDegreeOfTheGraph() {
        assertEquals(5, graphProcessor.maxDegree(graph));
    }

    @Test
    public void itShouldGiveUsTheAverageNumberDegree() {
        assertEquals(2.5, graphProcessor.averageDegree(graph));
    }

    @Test
    public void itShouldGiveUsTheTotalNumberOfSelfLoopsInTheGraph() {
        graph.addEdge(0, 0);
        assertEquals(1, graphProcessor.numberOfSelfLoops(graph));
    }
}