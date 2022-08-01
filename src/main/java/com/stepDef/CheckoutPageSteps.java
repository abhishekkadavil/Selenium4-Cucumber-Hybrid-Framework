package com.stepDef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.DriverFactory;

import io.cucumber.java.en.When;

public class CheckoutPageSteps {
	
	@When("checkout the cart")
	public void checkout_the_cart() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriverFactory().getWebDriver(), Duration.ofMillis(100000));
		wait.until(ExpectedConditions.invisibilityOf(DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@id='bar-notification']"))));
		
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//a[@class='ico-cart']")).click();
		
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='termsofservice']")).click();
		
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//button[@id='checkout']")).click();
	}

}
