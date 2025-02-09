package com.utils;


/**
 * @author Abhishek Kadavil
 */
public class PassPercentageExecutionControl {

    private PassPercentageExecutionControl(){

    }

    private static int failedTestsCount = 0;

    public static void incrementFailedTests() {
        failedTestsCount++;
    }

    public static boolean shouldStopExecution(int maxFailedTest) {
        return failedTestsCount >= maxFailedTest;
    }
}
