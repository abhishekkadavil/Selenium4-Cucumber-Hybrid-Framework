package com.runners;

import com.listeners.RetryListener;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.*;

/**
 * @author Abhishek Kadavil
 */
@CucumberOptions(tags = "@Login",
        features = "Features",
        monochrome = true,
        dryRun = false,
        glue = "com.stepdef",
        plugin = {"com.utils.TestListener",
                "rerun:target/failedrerun.txt"
        })
public class TestRunner extends AbstractTestNGCucumberTests {

    /**
     * Test can be executed parallel or sequentially;
     * Set the parallel = true to execute test parallel,
     * false to execute test sequentially
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /** Implemented for retrying flaky test cases*/
    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios",
            retryAnalyzer = RetryListener.class
    )
    @Override
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper, featureWrapper);
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
