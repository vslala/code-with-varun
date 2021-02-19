package com.codewithvarun;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AlgoRacerTest {


    @Test
    void itShouldGenerateReportAfterRunningAlgoRacerForAllTheSortingAlgorithms() throws IOException {
        var report = new File("src/test/resources/report.csv");
        int maxArrSize = 1000;
        var algoRacer = new AlgoRacer(report, maxArrSize);

        algoRacer.runTimes(1);

        assertTrue(report.exists());
    }
}