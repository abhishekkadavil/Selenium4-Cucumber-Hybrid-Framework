package com.stepDef;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.runners.RunnerHelper;
import com.utils.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Base64;

public class Hooks {

    BrowserFactory bf = new BrowserFactory();
    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }


    @Before
    public void beforeScenario(Scenario scenario) {

        //Create new test for each scenario
        testContext.setScenario(scenario);

        ExtentTest test = RunnerHelper.extent.createTest(scenario.getName());
        ReporterFactory.getInstance().setExtentTestList(test);

        //Create new chrome for each scenario
        DriverFactory.getDriverFactory().setWebDriver(bf.getBrowser(RunnerHelper.configUtil.getBrowser()));

        DriverFactory.getDriverFactory().getWebDriver().manage().window().maximize();
        DriverFactory.getDriverFactory().getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(RunnerHelper.configUtil.getImplicitlyWait())));
        DriverFactory.getDriverFactory().getWebDriver().navigate().to(RunnerHelper.configUtil.getBaseURL());

    }

    @After
    public void afterScenario(Scenario scenario) {

		//Passed step adding screenshot
        InputStream in;
        String base64 = "";
        File srcfile;

        if (scenario.getStatus().toString().equalsIgnoreCase("PASSED")) {
            srcfile = ((TakesScreenshot) DriverFactory.getDriverFactory().getWebDriver()).getScreenshotAs(OutputType.FILE);
            try {
                in = new FileInputStream(srcfile);
                byte[] imageBytes = IOUtils.toByteArray(in);
                base64 = Base64.getEncoder().encodeToString(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ReporterFactory.getInstance().getExtentTest().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
        }


		//Close browser
        DriverFactory.getDriverFactory().closeBrowser();

    }


}
