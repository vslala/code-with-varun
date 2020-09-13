package com.codewithvarun;

import org.junit.jupiter.api.Test;

class PerformanceTest {

    @Test
    public void itShouldCheckThePerformanceOfArrayListAndLinkeDList() {
        var performanceChecker  = new Performance();
        performanceChecker.checkPerformance();
    }

}