package com.stepDef;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.utils.TestContext;
import org.apache.commons.compress.utils.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Base64;

public class InteractionHelper {

    @Inject
    TestContext testContext;

    public WebElement typeElement(By by, String input) {
        WebDriverWait wait = new WebDriverWait(testContext.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.clear();
        element.sendKeys(input);
        return element;

        //the return element statement can be use to rerun the current element to the called function so that the
        // called function can again manipulate the element or pass it to any other functions
    }

    public WebElement clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(testContext.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
        return element;
    }

    public WebElement selectElementByText(By by, String textToBeSelected) {
        WebDriverWait wait = new WebDriverWait(testContext.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        Select sel = new Select(element);
        sel.selectByVisibleText(textToBeSelected);
        return element;
    }

    public WebElement selectElementByIndex(By by, int index) {
        WebDriverWait wait = new WebDriverWait(testContext.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        Select sel = new Select(element);
        sel.selectByIndex(index);
        return element;
    }

    public String getText(By by) {
        WebDriverWait wait = new WebDriverWait(testContext.getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element.getText();
    }

    public String takeScreenShotOfElement(By by) {

        String base64="";
        File srcfile = testContext.getDriver().findElement(by).getScreenshotAs(OutputType.FILE);
        try {
            InputStream in = new FileInputStream(srcfile);
            byte[] imageBytes = IOUtils.toByteArray(in);
            base64 = Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }

    public String takeScreenShotOfWebPage() {
        String base64="";
        File srcfile = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            InputStream in = new FileInputStream(srcfile);
            byte[] imageBytes = IOUtils.toByteArray(in);
            base64 = Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }
}
