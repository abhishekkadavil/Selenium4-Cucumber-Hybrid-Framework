package com.factories;

import com.aventstack.extentreports.ExtentTest;

/**
 * @author Abhishek Kadavil
 */
public class ReporterFactory {


    private ReporterFactory() {
    }

    private static ReporterFactory ReporterFactoryInstance = new ReporterFactory();

    public static ReporterFactory getInstance() {
        return ReporterFactoryInstance;
    }


    ThreadLocal<ExtentTest> extentTestList = new ThreadLocal<ExtentTest>();

    public ExtentTest getExtentTest() {
        return extentTestList.get();
    }

    public void setExtentTestList(ExtentTest extentTest) {
        extentTestList.set(extentTest);
    }

    public void finishedExtentTest() {
        extentTestList.remove();
    }

}
