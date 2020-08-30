package com.codewithvarun;

public class Histogram {


    public void run() {
        String[] words = {"I", "recommend", "polygene", "lubricants"};
        int[] histogram = new int[5];

        for (String left: words) {
            for (String right: words) {
                String pair = left + right;
                int bucket = pair.hashCode() % histogram.length;
                histogram[bucket]++;
            }
        }

        int pairCount = 0;
        for (int freq: histogram) {
            pairCount += freq;
        }

        System.out.println('C' + pairCount);
    }
}
