package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(tags = "@All",
					features = "Features",
					monochrome = true,
					dryRun = false,
					glue = "com.stepDef",
					plugin={"com.utils.TestListener",
                            "rerun:target/failedrerun.txt"
                    })
public class TestRunner extends AbstractTestNGCucumberTests {

    /*
        Test can be executed parallel or sequentially;
        Set the parallel = true to execute test parallel,
        false to execute test sequentially
    * */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
    @BeforeClass
    public void beforeClass() { RunnerHelper.beforeTestSuit();}

    @AfterClass
    public void afterClass()
    {
        RunnerHelper.afterTestSuit();
    }

}
