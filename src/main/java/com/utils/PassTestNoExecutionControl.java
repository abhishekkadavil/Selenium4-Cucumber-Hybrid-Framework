package com.utils;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Abhishek Kadavil
 */
public class PassTestNoExecutionControl {

    private PassTestNoExecutionControl(){ }

    private static final AtomicInteger failedTestsCount = new AtomicInteger(0);

    public static void incrementFailureCount() {
        failedTestsCount.incrementAndGet();
    }

    public static boolean shouldSkipTest(int maxFailedTest) {
        return failedTestsCount.get() >= maxFailedTest;
    }
}
