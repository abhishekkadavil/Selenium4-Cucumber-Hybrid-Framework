package com.stepDef;

import org.openqa.selenium.By;

import com.utils.DriverFactory;

import io.cucumber.java.en.When;

public class ShippingMethodPageSteps {
	
	@When("select shipping method")
	public void select_shipping_method() {
		
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@id='shipping-method-buttons-container']/button[@class='button-1 shipping-method-next-step-button']")).click();

	}

}
