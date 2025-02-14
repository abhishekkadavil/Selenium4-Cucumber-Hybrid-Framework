package com.stepdef;

import com.google.inject.Inject;
import com.utils.ScenarioContext;
import io.cucumber.java.en.Then;

/**
 * @author Abhishek Kadavil
 */
public class OrderHistoryPageSteps {

    @Inject
    ScenarioContext scenarioContext;

    @Then("order can be view in order history")
    public void order_can_be_view_in_order_history() {
        scenarioContext.getDriver().navigate().to("http://localhost/order/history");
    }

}
