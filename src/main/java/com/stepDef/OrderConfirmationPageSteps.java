package com.stepDef;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class OrderConfirmationPageSteps {
	@Inject
	InteractionHelper interactionHelper;

	private By confirm_order_next_step_btn = By.xpath("//button[@class='button-1 confirm-order-next-step-button']");
	private By order_completed_asrt = By.xpath("//div[@class='section order-completed']/div[@class='title']");
	
	@When("confirm order")
	public void confirm_order() {
		interactionHelper.clickElement(confirm_order_next_step_btn);
	}
	
	@Then("order should be placed successfully")
	public void order_should_be_placed_successfully() {
		Assert.assertEquals(interactionHelper.getText(order_completed_asrt),"Your order has been " +
				"successfully processed!");
	}

}
