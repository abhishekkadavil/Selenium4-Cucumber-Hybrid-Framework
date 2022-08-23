package com.utils;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import lombok.Data;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

@Data
@ScenarioScoped
public class TestContext {

//    Since this class is marked as @ScenarioScoped each scenario will have their own copy of the TestContext class
//    the object state will not be leaked to other objects

    HashMap <String,String> scenarioContext = new HashMap<>();
    @Inject
    DriverFactory driverFactory;

    //code related to config reader
    @Getter
    ConfigUtil configUtil = ConfigFactory.create(ConfigUtil.class);

    //@Data annotation will auto generate getter so that we can use getDriver in other classes, as for initialisation
    // that is done from invokeDriver() -> beforeScenario
    WebDriver driver;

    public void invokeDriver(){
        String browser = (System.getProperty("browser")==null) ? configUtil.getBrowser() : System.getProperty("browser");
        String execType = (System.getProperty("execType")==null) ? "local" : System.getProperty("execType");
        this.driver = driverFactory.getBrowser(browser,execType);
        this.driver.manage().window().maximize();
    }

    public void navigateBrowser(String url){
        this.driver.get(url);
    }
    public void quitDriver(){
        this.driver.quit();
    }

}
