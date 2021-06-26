package com.codewithvarun.sort;

public class Timer {

    public static Long timeIt(Runnable job) {
        long startMillis = System.currentTimeMillis();
        job.run();
        return System.currentTimeMillis() - startMillis;
    }
}
