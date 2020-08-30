package com.codewithvarun;

public class Timer {

    public Timer(Runnable job) {
        long startMillis = System.currentTimeMillis();
        job.run();
        System.out.printf("Total Time Taken: %dms", (System.currentTimeMillis() - startMillis));
    }
}
