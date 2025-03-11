package com.utils;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import lombok.Data;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

/**
 * @author Abhishek Kadavil
 */
@Data
@ScenarioScoped
public class ScenarioContext {

    HashMap<String, String> session = new HashMap<>();
    @Inject
    DriverFactory driverFactory;

    //@Data annotation will auto generate getter so that we can use getDriver in other classes, as for initialisation
    // that is done from invokeDriver() -> beforeScenario
    WebDriver driver;

    public void invokeDriver() {
        String browser = (System.getProperty("browser") == null) ? TestContext.configUtil.getBrowser() : System.getProperty("browser");
        String execType = (System.getProperty("execType") == null) ? "local" : System.getProperty("execType");
        String chromeVersion = (System.getProperty("chromeVersion") == null) ? TestContext.configUtil.getChromeVersion() : System.getProperty("chromeVersion");
        this.driver = driverFactory.getBrowser(browser, execType, chromeVersion);
        this.driver.manage().window().maximize();
    }

    public void invokeDriver(String browser) {
        String execType = (System.getProperty("execType") == null) ? "local" : System.getProperty("execType");
        String chromeVersion = (System.getProperty("chromeVersion") == null) ? TestContext.configUtil.getChromeVersion() : System.getProperty("chromeVersion");
        this.driver = driverFactory.getBrowser(browser, execType, chromeVersion);
        this.driver.manage().window().maximize();
    }

    public void navigateBrowser(String url) {
        this.driver.get(url);
    }

    public void quitDriver() {
        this.driver.quit();
    }

}
