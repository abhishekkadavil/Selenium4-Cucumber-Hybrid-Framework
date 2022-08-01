package com.stepDef;

import com.testDataModels.Item;
import com.utils.DriverFactory;
import com.utils.TestDataFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class ItemPageSteps {
	
	@When("add item to cart")
	public void add_item_to_cart() {
		
		for (Item item : TestDataFactory.getInstance().getTestDataModel().getItems()) {
			
			DriverFactory.getDriverFactory().getWebDriver().navigate().to(item.getUrl());
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@aria-label='Enter a " +
					"quantity']")).clear();
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@aria-label='Enter a " +
					"quantity']")).sendKeys(item.getQuantity());
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//button[@class='button-1 add-to-cart-button']")).click();
			
		} 

	}

}
