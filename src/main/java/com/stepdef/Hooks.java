package com.stepdef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.inject.Inject;
import com.runners.RunnerHelper;
import com.utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.testng.SkipException;

/**
 * @author Abhishek Kadavil
 */
@Slf4j
public class Hooks {

    @Inject
    ScenarioContext scenarioContext;

    @Inject
    InteractionHelper interactionHelper;

    @Before
    public void beforeScenario(Scenario scenario) {

        try{
            log.info("beforeScenario {}", scenario.getName());

            // Create new test for each scenario
            ExtentTest test = RunnerHelper.extent.createTest(scenario.getName());
            ReporterFactory.getInstance().setExtentTestList(test);

            // Pass percentage execution control logic
            if (TestContext.configUtil.getPassTestExecutionControlNumFlag() && PassTestExecutionControlNum.shouldSkipTest(TestContext.configUtil.getPassTestExecutionControlNum())) {
                log.warn("Skipping further test execution due to failures in the first {} tests.", TestContext.configUtil.getPassTestExecutionControlNum());
                throw new SkipException("Skipping test execution as first "+ TestContext.configUtil.getPassTestExecutionControlNum() +" tests failed.");
            }
        }
        catch (SkipException skipEx) {
            log.warn("Test execution skipped: {}", skipEx.getMessage());
            throw skipEx;
        }
        catch (Exception e){
            log.error("Setup failed in @Before hook: ", e);
            throw e;
        }
    }

    @After
    public void afterScenario(Scenario scenario) {

        try{
            log.info("afterScenario {}", scenario.getName());

            if(scenarioContext.getDriver()!=null) {
                //Passed step adding screenshot
                if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
                    ReporterFactory.getInstance().getExtentTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(interactionHelper.takeScreenShotOfWebPage()).build());
                } else if (scenario.getStatus().toString().equalsIgnoreCase("FAILED")) {
                    ReporterFactory.getInstance().getExtentTest().fail(MediaEntityBuilder.createScreenCaptureFromBase64String(interactionHelper.takeScreenShotOfWebPage()).build());
                }

                // Pass percentage execution control logic
                if (TestContext.configUtil.getPassTestExecutionControlNumFlag() && scenario.isFailed()) {
                    PassTestExecutionControlNum.incrementFailureCount();
                }
            }
        }
        catch (Exception e){
            log.error("Setup failed in @After hook: ", e);
        }
        finally {
            if(scenarioContext.getDriver()!=null) {
                //Close browser
                scenarioContext.quitDriver();
            }
        }
    }


}
