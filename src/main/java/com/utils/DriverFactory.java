package com.utils;

import com.epam.healenium.SelfHealingDriver;
import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@ScenarioScoped
public class DriverFactory {

    @Inject
    TestContext testContext;


    public SelfHealingDriver getBrowser(String browser, String execType, String chromeVersion) {
        SelfHealingDriver driver = null;

        //Suppress selenium logs
        Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        if (browser.equalsIgnoreCase("chrome")) {
            //Suppress chrome driver logs
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");

            // Specify the Chrome version
            if(chromeVersion.isEmpty()){
                chromeOptions.setBrowserVersion(chromeVersion);
            }

            if (execType.equalsIgnoreCase("local")) {
                WebDriver delegate = new ChromeDriver(chromeOptions);
                driver = SelfHealingDriver.create(delegate);
            }
            else if (execType.equalsIgnoreCase("grid")) {
                try {
                    WebDriver delegate = new RemoteWebDriver(new URL(testContext.getConfigUtil().getSeleniumGridUrl()), chromeOptions);
                    driver = SelfHealingDriver.create(delegate);
                } catch (MalformedURLException e) {
                    log.error(e.toString());
                    Assert.fail("MalformedURLException thrown, Grid URL is not correct");
                }

            } else {
                log.info("************************ execType not recognised ************************");
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
