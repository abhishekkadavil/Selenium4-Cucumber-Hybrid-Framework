package com.stepDef;

import org.openqa.selenium.By;

import com.utils.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrderConfirmationPageSteps {
	
	
	@When("confirm order")
	public void confirm_order() {
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']")).click();
	}
	
	@Then("order should be placed successfully")
	public void order_should_be_placed_successfully() {

		Assert.assertEquals(DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@class='section order-completed']/div[@class='title']")).getText(),"Your order has been successfully processed!");

	}

}
