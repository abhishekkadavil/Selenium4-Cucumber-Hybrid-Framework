package com.utils;

import com.epam.healenium.SelfHealingDriver;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Abhishek Kadavil
 */
@ScenarioScoped
public class DriverFactory {

    @Inject
    TestContext testContext;

    public SelfHealingDriver getBrowser(String browser, String execType) {
        SelfHealingDriver driver = null;

        //Suppress selenium logs
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome")) {
            //Suppress chrome driver logs
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            ChromeOptions choptions = new ChromeOptions();
            choptions.addArguments("--incognito");
            if (execType.equalsIgnoreCase("local")) {
                WebDriver delegate = new ChromeDriver(choptions);
                driver = SelfHealingDriver.create(delegate);
            }
            else if (execType.equalsIgnoreCase("grid")) {
                try {
                    WebDriver delegate = new RemoteWebDriver(new URL(testContext.getConfigUtil().getSeleniumGridUrl()), choptions);
                    driver = SelfHealingDriver.create(delegate);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    Assert.fail("MalformedURLException thrown, Grid URL is not correct");
                }
            }
            else {
                System.out.println("************************ execType not recognised ************************");
            }

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions foptions = new FirefoxOptions();
            foptions.addArguments("-private");
            WebDriver delegate = new FirefoxDriver(foptions);
            driver = SelfHealingDriver.create(delegate);
        }


        return driver;

    }

}
