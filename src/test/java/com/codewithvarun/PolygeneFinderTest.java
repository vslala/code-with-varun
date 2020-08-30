package com.codewithvarun;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolygeneFinderTest {

    @Test
    public void itShouldPrintAllThePolygeneWords() {
        var polygeneFinder = new PolygeneFinder();
        polygeneFinder.printAll();
    }

}