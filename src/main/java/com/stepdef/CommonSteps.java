package com.stepdef;

import com.aventstack.chaintest.plugins.ChainTestCucumberListener;
import com.aventstack.chaintest.service.ChainPluginService;
import com.dataproviders.TestDataReader;
import com.google.inject.Inject;
import com.utils.ScenarioContext;
import com.utils.TestContext;
import io.cucumber.java.en.Given;

/**
 * @author Abhishek Kadavil
 */
public class CommonSteps {

    @Inject
    ScenarioContext scenarioContext;

    @Inject
    TestDataReader testDataReader;

    @Given("user is on home page and testdata present in {string}")
    public void user_is_on_home_page_and_testdata_present_in(String testDataPath) {

        // Initialising the driver
        scenarioContext.invokeDriver();
        scenarioContext.getDriver().navigate().to(TestContext.configUtil.getBaseURL());

        testDataPath = System.getProperty("user.dir") + "/TestData/" + testDataPath;
        testDataReader.loadData(testDataPath);
    }

    @Given("user is on home page in {string} browser and testdata present in {string}")
    public void user_is_on_home_page_in_browser_and_testdata_present_in(String driver, String testDataPath) {

        // Initialising the driver
        scenarioContext.invokeDriver(driver);
        scenarioContext.getDriver().navigate().to(TestContext.configUtil.getBaseURL());

        testDataPath = System.getProperty("user.dir") + "/TestData/" + testDataPath;
        testDataReader.loadData(testDataPath);
    }

    @Given("user is on home page and dynamic test data present in {string}")
    public void user_is_on_home_page_and_dynamic_test_data_present_in(String testDataPath) {

        // Initialising the driver
        scenarioContext.invokeDriver();
        scenarioContext.getDriver().navigate().to(TestContext.configUtil.getBaseURL());

        testDataPath = System.getProperty("user.dir") + "/TestData/" + testDataPath;
        testDataReader.loadData(testDataPath);
    }

    @Given("user is on home page in {string} browser and dynamic test data present in {string}")
    public void user_is_on_home_page_in_browser_and_dynamic_test_data_present_in(String driver, String testDataPath) {

        // Initialising the driver
        scenarioContext.invokeDriver(driver);
        scenarioContext.getDriver().navigate().to(TestContext.configUtil.getBaseURL());

        testDataPath = System.getProperty("user.dir") + "/TestData/" + testDataPath;
        testDataReader.loadData(testDataPath);
    }

}
