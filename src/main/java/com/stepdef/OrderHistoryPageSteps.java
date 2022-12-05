package com.stepdef;

import com.google.inject.Inject;
import com.utils.TestContext;
import io.cucumber.java.en.Then;

public class OrderHistoryPageSteps {

	@Inject
	TestContext testContext;
	
	@Then("order can be view in order history")
	public void order_can_be_view_in_order_history() {
		testContext.getDriver().navigate().to("http://localhost/order/history");
	}

}
