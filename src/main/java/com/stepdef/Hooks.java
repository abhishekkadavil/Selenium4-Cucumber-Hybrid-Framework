package com.stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.inject.Inject;
import com.runners.RunnerHelper;
import com.utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Abhishek Kadavil
 */
@Slf4j
public class Hooks {

    @Inject
    TestContext testContext;

    @Inject
    InteractionHelper interactionHelper;

    @Before
    public void beforeScenario(Scenario scenario) {

        log.info("beforeScenario {}", scenario.getName());

        // Initialising the driver
        testContext.invokeDriver();
        testContext.getDriver().navigate().to(testContext.getConfigUtil().getBaseURL());

        // Create new test for each scenario
        ExtentTest test = RunnerHelper.extent.createTest(scenario.getName());
        ReporterFactory.getInstance().setExtentTestList(test);

        // Pass percentage execution control logic
        if (testContext.getConfigUtil().getPassPercentageExecutionControlFlag() && PassPercentageExecutionControl.shouldStopExecution(testContext.getConfigUtil().getPassPercentageExecutionControlValue())) {
            log.error("Stopping further test execution due to failures in the first {} tests.", testContext.getConfigUtil().getPassPercentageExecutionControlValue());
            throw new PendingException("Stopping test execution as first "+ testContext.getConfigUtil().getPassPercentageExecutionControlValue() +" tests failed.");
        }
    }

    @After
    public void afterScenario(Scenario scenario) {

        log.info("afterScenario {}", scenario.getName());

        //Passed step adding screenshot
        if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
            ReporterFactory.getInstance().getExtentTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(interactionHelper.takeScreenShotOfWebPage()).build());
        } else if (scenario.getStatus().toString().equalsIgnoreCase("FAILED")) {
            ReporterFactory.getInstance().getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(interactionHelper.takeScreenShotOfWebPage()).build());
        }

        //Close browser
        testContext.quitDriver();

        // Pass percentage execution control logic
        if (testContext.getConfigUtil().getPassPercentageExecutionControlFlag() && scenario.isFailed()) {
            PassPercentageExecutionControl.incrementFailedTests();
        }

    }


}
