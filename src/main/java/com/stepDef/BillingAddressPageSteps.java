package com.stepDef;

import com.utils.DriverFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class BillingAddressPageSteps {
	
	@When("select billing address")
	public void select_billing_address() {
		
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@id='billing-buttons-container']/button[@name='save']")).click();

	}

}
