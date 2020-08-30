package com.codewithvarun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PolygeneFinder {

    public void printAll() {
        try {
            String[] words = Files.readAllLines(Paths.get("/usr/share/dict/words")).toArray(new String[]{});
            new Timer(() -> analyzeWordPair(words));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void analyzeWordPair(String[] words) {
        for (String left : words) {
            for (String right : words) {
                String pair = left + right;
                if (pair.hashCode() == Integer.MIN_VALUE) {
                    System.out.println(pair);
                }
            }
        }
    }
}
