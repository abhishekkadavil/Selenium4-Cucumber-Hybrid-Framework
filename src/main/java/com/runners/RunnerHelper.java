package com.runners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Abhishek Kadavil
 */
public class RunnerHelper {

    public static ExtentSparkReporter spark;
    public static ExtentReports extent;

    public static void  beforeTestSuit() {
        //code related to report
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportFileName = "Test-Report-" + timeStamp + ".html";

        RunnerHelper.spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/Report/" + reportFileName);
        RunnerHelper.extent = new ExtentReports();
        RunnerHelper.extent.attachReporter(RunnerHelper.spark);
        RunnerHelper.extent.setSystemInfo("os", "Ubuntu");
        RunnerHelper.extent.setSystemInfo("Tester", "Abhishek Kadavil");
        RunnerHelper.extent.setSystemInfo("Git repo", "https://github.com/abhishekkadavil");
    }

    public static void afterTestSuit() {
        RunnerHelper.extent.flush();
    }

}
