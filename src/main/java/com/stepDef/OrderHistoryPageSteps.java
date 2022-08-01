package com.stepDef;

import com.utils.DriverFactory;

import io.cucumber.java.en.Then;

public class OrderHistoryPageSteps {
	
	@Then("order can be view in order history")
	public void order_can_be_view_in_order_history() {
		DriverFactory.getDriverFactory().getWebDriver().navigate().to("http://localhost/order/history");
	}

}
