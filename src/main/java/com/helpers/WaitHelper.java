package com.helpers;

import com.enums.WaitStrategy;
import com.utils.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

/**
 * @author Abhishek Kadavil
 */
public class WaitHelper {

    public static void untilJqueryIsDone(WebDriver driver) {
        untilJqueryIsDone(driver, TestContext.configUtil.getImplicitWait());
    }

    public static void untilJqueryIsDone(WebDriver driver, Long timeoutInSeconds) {
        until(driver, (d) ->
        {
            Boolean isJqueryCallDone = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
            if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
            return isJqueryCallDone;
        }, timeoutInSeconds);
    }

    public static void untilPageLoadComplete(WebDriver driver) {
        untilPageLoadComplete(driver, TestContext.configUtil.getImplicitWait());
    }

    public static void untilPageLoadComplete(WebDriver driver, Long timeoutInSeconds) {
        until(driver, (d) ->
        {
            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded) System.out.println("Document is loading");
            return isPageLoaded;
        }, timeoutInSeconds);
    }

    public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition) {
        until(driver, waitCondition, TestContext.configUtil.getImplicitWait());
    }

    private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        webDriverWait.withTimeout(Duration.ofSeconds(timeoutInSeconds));
        try {
            webDriverWait.until(waitCondition);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void fluentWait(WebDriver driver, WebElement element, Long timeoutInSeconds) {
        Wait<WebDriver> wait = null;
        try {
            wait = new FluentWait<WebDriver>((WebDriver) driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(Exception.class);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        } catch (Exception e) {
        }
    }

    public void implicitWait(WebDriver driver, Long timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
    }

    public void explicitWait(WebDriver driver, WebElement element, Long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void pageLoadTimeOut(WebDriver driver, Long timeoutInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeoutInSeconds));
    }

    public static WebElement performExplicitWait(WebDriver driver, WaitStrategy waitstrategy, By by) {
        WebElement element = null;
        if(waitstrategy == WaitStrategy.CLICKABLE) {
            element = 	new WebDriverWait(driver, Duration.ofSeconds(TestContext.configUtil.getExplicitWait()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitstrategy == WaitStrategy.PRESENCE) {
            element =	new WebDriverWait(driver, Duration.ofSeconds(TestContext.configUtil.getExplicitWait()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitstrategy == WaitStrategy.VISIBLE) {
            element =new WebDriverWait(driver, Duration.ofSeconds(TestContext.configUtil.getExplicitWait()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(waitstrategy == WaitStrategy.NONE) {
            element = driver.findElement(by);
        }
        return element;
    }

}
