package com.stepdef;

import com.google.inject.Inject;
import com.utils.ScenarioContext;
import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author Abhishek Kadavil
 */
@Slf4j
public class InteractionHelper {

    @Inject
    ScenarioContext scenarioContext;

    public WebElement typeElement(By by, String input) {

        log.info("typeElement " + by.toString());
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(scenarioContext.getDriver(), Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            element.clear();
            element.sendKeys(input);
            return element;
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            log.error("typeElement " + ex.toString());
            return element;
        }

        //the return element statement can be use to rerun the current element to the called function so that the
        // called function can again manipulate the element or pass it to any other functions
    }

    public WebElement clickElement(By by) {

        log.info("clickElement " + by.toString());
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(scenarioContext.getDriver(), Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            element.click();
            return element;
        } catch (Exception ex) {
            log.error("***** Error Occured ***** " + ex);
            Assert.fail("***** Error Occured *****" + ex);
            return element;
        }
    }

    public WebElement clickElementUsingJS(By by) {

        log.info("clickElement " + by.toString());
        WebElement element = null;
        try {
            element = scenarioContext.getDriver().findElement(by);
            JavascriptExecutor js = (JavascriptExecutor) scenarioContext.getDriver();
            js.executeScript("arguments[0].click();", element);
            return element;
        } catch (Exception ex) {
            log.error("***** Error Occured ***** " + ex);
            Assert.fail("***** Error Occured *****" + ex);
            return element;
        }
    }

    public WebElement selectElementByText(By by, String textToBeSelected) {

        log.info("selectElementByText " + by.toString());
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(scenarioContext.getDriver(), Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            Select sel = new Select(element);
            sel.selectByVisibleText(textToBeSelected);
            return element;
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            log.error("selectElementByText " + ex.toString());
            return element;
        }
    }

    public WebElement selectElementByIndex(By by, int index) {

        log.info("selectElementByIndex " + by.toString());
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(scenarioContext.getDriver(), Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            Select sel = new Select(element);
            sel.selectByIndex(index);
            return element;
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            log.error("selectElementByIndex " + ex.toString());
            return element;
        }

    }

    public String getText(By by) {

        log.info("getText " + by.toString());
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(scenarioContext.getDriver(), Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            return element.getText();
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            log.error("getText " + ex.toString());
            return "";
        }
    }

    public String getAttribute(By by, String attName) {

        log.info("getAttribute " + by.toString());
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(scenarioContext.getDriver(), Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            String value = element.getAttribute(attName);
            return value;
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            log.error("getAttribute " + ex.toString());
            return "";
        }
    }

    public String getTitle() {
        WebElement element = null;
        try {
            String value = scenarioContext.getDriver().getTitle();
            return value;
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            return "";
        }
    }

    public List<WebElement> getListOfWebElements(By by) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(scenarioContext.getDriver(), Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return element.findElements(by);
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            return new ArrayList<>();
        }


    }

    public boolean validateElementIsDisplayed(By by) {
        boolean b = false;
        try {
            b = scenarioContext.getDriver().findElement(by).isDisplayed();
            return b;
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
            return b;
        }
    }

    public void switchToSecondWindowTab() {
        WebElement element = null;
        try {
            String[] handles = (String[]) scenarioContext.getDriver().getWindowHandles().toArray();
            scenarioContext.getDriver().switchTo().window(handles[1]);
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
        }

    }

    public void switchToDefaultWindowTab() {
        WebElement element = null;
        try {
            String[] handles = (String[]) scenarioContext.getDriver().getWindowHandles().toArray();
            scenarioContext.getDriver().switchTo().window(handles[0]);
        } catch (Exception ex) {
            Assert.fail("***** Error Occured *****" + ex);
        }
    }

    public String takeScreenShotOfElement(By by) {

        String base64 = "";
        File srcfile = scenarioContext.getDriver().findElement(by).getScreenshotAs(OutputType.FILE);
        try {
            InputStream in = new FileInputStream(srcfile);
            byte[] imageBytes = in.readAllBytes();
            base64 = Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }

    public String takeScreenShotOfWebPage() {

        log.info("takeScreenShotOfWebPage");
        String base64 = "";
        File srcfile = ((TakesScreenshot) scenarioContext.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            InputStream in = new FileInputStream(srcfile);
            byte[] imageBytes = in.readAllBytes();
            base64 = Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }
}
