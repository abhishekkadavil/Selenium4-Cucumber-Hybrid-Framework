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

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            /* Code to manage @Author and @Category tags */
            Collection<String> tagsCollection = scenario.getSourceTagNames();
            Set<String> tags = new HashSet<>(tagsCollection);

            tags.forEach(tag -> {
                if (tag.startsWith("@Author")) {
                    ReporterFactory.getInstance().getExtentTest().assignAuthor(extractedTagValue(tag));
                } else if (tag.startsWith("@Category")) {
                    ReporterFactory.getInstance().getExtentTest().assignCategory(extractedTagValue(tag));
                }
            });

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

    private String extractedTagValue(String tag) {

        Pattern pattern;
        Matcher matcher = null;
        if (tag.startsWith("@Author")) {
            pattern = Pattern.compile("@Author\\(\"([^\"]+)\"\\)");
            matcher = pattern.matcher(tag);
        }
        if (tag.startsWith("@Category")) {
            pattern = Pattern.compile("@Category\\(\"([^\"]+)\"\\)");
            matcher = pattern.matcher(tag);
        }

        if(matcher != null)
        {
            if (matcher.find()) {
                return matcher.group(1);  // Return the author's name
            }
        }
        return "Unknown";
    }

}
