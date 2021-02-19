package com.codewithvarun;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.Arrays.*;

public class AlgoRacer {


    private final File outputFile;
    private final int maxArrSize;

    public AlgoRacer(File outputFile, int maxArrSize) {
        this.outputFile = outputFile;
        this.maxArrSize = maxArrSize;

        if (!outputFile.exists()) {
            try {
                outputFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void runTimes(int rounds) throws IOException {
        var rand = new Random();
        var report = new StringBuilder("BubbleSort,SelectionSort,Insertion,Shell,Merge,Quick")
                .append(System.lineSeparator());
        IntStream.range(0, rounds).forEach(round -> {

            int[] testArr = generateRandomUnsortedArr(rand);

            report
                    .append(Sort.bubbleSort(copyOf(testArr, testArr.length))).append(",")
                    .append(Sort.selectionSort(copyOf(testArr, testArr.length))).append(",")
                    .append(Sort.insertionSort(copyOf(testArr, testArr.length))).append(",")
                    .append(Sort.shellSort(copyOf(testArr, testArr.length))).append(",")
                    .append(Sort.mergeSort(copyOf(testArr, testArr.length))).append(",")
                    .append(Sort.quickSort(copyOf(testArr, testArr.length))).append(",")
                    .append(System.lineSeparator());

        });

        Files.write(Paths.get(outputFile.getAbsolutePath()), Collections.singleton(report.toString()));
    }

    private int[] generateRandomUnsortedArr(Random rand) {
        var testArr = new int[rand.nextInt(maxArrSize)];
        IntStream.range(0, maxArrSize)
                .forEach(index -> testArr[index] = rand.nextInt(1000));
        return testArr;
    }
}
