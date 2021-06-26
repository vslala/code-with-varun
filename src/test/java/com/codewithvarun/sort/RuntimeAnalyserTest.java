package com.codewithvarun.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuntimeAnalyserTest {

    private RuntimeAnalyser runtimeAnalyser;

    @BeforeEach
    void setup() {
        runtimeAnalyser = new RuntimeAnalyser(List.of(
                new SelectionSort(),
                new InsertionSort(),
                new BottomUpMergeSort(),
                new QuickSort(),
                new RecursiveSort()
        ), 10000);
    }

    @Test
    void itShouldTimeTheAlgorithms() {
        List<Record> records = runtimeAnalyser.run();
        System.out.println(records.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        assertEquals(5, records.size());
    }

}