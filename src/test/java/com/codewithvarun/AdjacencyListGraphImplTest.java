package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyListGraphImplTest {

    AdjacencyListGraphImpl graph =  new AdjacencyListGraphImpl(10);

    @Test
    public void itShouldConnectAnEdgeFromVertex1ToVertex2() {
        graph.addEdge(0, 6);
        graph.addEdge(0, 5);
        graph.addEdge(0, 7);
        graph.addEdge(0, 1);

        Set<Integer> adjVertices = StreamSupport.stream(graph.adj(0).spliterator(), false).collect(Collectors.toSet());
        Set<Integer> adjVertices2 = StreamSupport.stream(graph.adj(5).spliterator(), false).collect(Collectors.toSet());

        assertTrue(adjVertices.contains(6));
        assertTrue(adjVertices.contains(5));
        assertTrue(adjVertices.contains(6));
        assertTrue(adjVertices.contains(1));
        assertTrue(adjVertices2.contains(0));
    }

}