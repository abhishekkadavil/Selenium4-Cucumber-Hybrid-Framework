package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

/**
 * @author Abhishek Kadavil
 */
@CucumberOptions(
        features = "@target/failedrerun.txt",
        monochrome = true,
        dryRun = false,
        glue = "com.stepDef",
        plugin = {"com.listeners.TestListener",
                "rerun:target/failedrerun.txt"
        })
public class FailedTcRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    public void beforeClass() {
        RunnerHelper.beforeTestSuit();
    }

    @AfterClass
    public void afterClass() {
        RunnerHelper.afterTestSuit();
    }

}