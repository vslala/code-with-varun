package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

class PolygeneFinderTest {

    @Test
    public void itShouldPrintAllThePolygeneWords() {
        var polygeneFinder = new PolygeneFinder();
        polygeneFinder.printAll();
    }

    @Test
    public void sandbox() {
        String powersOf31 = IntStream.iterate(1, x -> x * 31).limit(64).mapToObj(String::valueOf).collect(joining(", "));
        System.out.println(powersOf31);
    }

}