package com.stepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.inject.Inject;
import com.runners.RunnerHelper;
import com.utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

    @Inject
    TestContext testContext;

    @Inject
    InteractionHelper interactionHelper;

    @Before
    public void beforeScenario(Scenario scenario) {

        log.info("beforeScenario " + scenario.getName());

        //Initialising the driver
        testContext.invokeDriver();
        testContext.getDriver().navigate().to(testContext.getConfigUtil().getBaseURL());

        //Create new test for each scenario
        ExtentTest test = RunnerHelper.extent.createTest(scenario.getName());
        ReporterFactory.getInstance().setExtentTestList(test);
    }

    @After
    public void afterScenario(Scenario scenario) {

        log.info("afterScenario " + scenario.getName());

		//Passed step adding screenshot
        if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
            ReporterFactory.getInstance().getExtentTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(interactionHelper.takeScreenShotOfWebPage()).build());
        } else if (scenario.getStatus().toString().equalsIgnoreCase("FAILED")) {
            ReporterFactory.getInstance().getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(interactionHelper.takeScreenShotOfWebPage()).build());
        }

        //Close browser
        testContext.quitDriver();

    }


}
