package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

class PolygeneFinderTest {

    @Test
    public void itShouldPrintAllThePolygeneWords() {
        var polygeneFinder = new PolygeneFinder();
        polygeneFinder.printAll();
    }

    @Test
    public void sandbox() throws IOException {
//        String powersOf31 = IntStream.iterate(1, x -> x * 31).limit(64).mapToObj(String::valueOf).collect(joining(", "));
//        System.out.println(powersOf31);
        String[] words = Files.readAllLines(Paths.get("/usr/share/dict/words")).toArray(new String[]{});
        Map<Integer, Map<Integer, List<String>>> output = Arrays.asList(words).stream().collect(groupingBy(String::length, groupingBy(String::hashCode)));
        System.out.println(output.get(5));


    }

}