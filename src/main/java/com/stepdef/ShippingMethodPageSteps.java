package com.stepdef;

import com.google.inject.Inject;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

/**
 * @author Abhishek Kadavil
 */
public class ShippingMethodPageSteps {
    @Inject
    InteractionHelper interactionHelper;

    private By shipping_method_next_step_btn_btn = By.xpath("//div[@id='shipping-method-buttons-container']/button[@class='button-1 " +
            "shipping-method-next-step-button']");

    @When("select shipping method")
    public void select_shipping_method() {
        interactionHelper.clickElement(shipping_method_next_step_btn_btn);
    }

}
