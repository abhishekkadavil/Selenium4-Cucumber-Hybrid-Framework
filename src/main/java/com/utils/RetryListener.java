package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Abhishek Kadavil
 */
public class RetryListener implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int maxRetryCount = TestContext.configUtil.getMaxFlakyTestRetryCount(); // Change this to however many retries you want

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // No more retries
    }
}
