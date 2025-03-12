package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Abhishek Kadavil
 */
public class RetryListener implements IRetryAnalyzer {

    ThreadLocal<Integer> retryCount = ThreadLocal.withInitial(()->0);

    // Change this to however many retries you want
    private final int maxRetryCount = TestContext.configUtil.getMaxFlakyTestRetryCount();

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount.get() < maxRetryCount) {
            retryCount.set(retryCount.get() + 1);
            return true; // Retry the test
        }
        return false; // No more retries
    }
}
