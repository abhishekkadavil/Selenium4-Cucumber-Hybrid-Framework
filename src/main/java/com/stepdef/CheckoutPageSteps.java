package com.stepdef;

import com.google.inject.Inject;
import com.utils.ScenarioContext;
import org.openqa.selenium.By;
import io.cucumber.java.en.When;

/**
 * @author Abhishek Kadavil
 */
public class CheckoutPageSteps {

    @Inject
    InteractionHelper interactionHelper;
    @Inject
    ScenarioContext scenarioContext;

    private By checkout_notification_bar = By.xpath("//div[@id='bar-notification']//span");
    private By shopping_cart_btn = By.xpath("//a[@class='ico-cart']");
    private By termsofservice_chkBx = By.xpath("//input[@id='termsofservice']");
    private By checkout_btn = By.xpath("//button[@id='checkout']");

    @When("checkout the cart")
    public void checkout_the_cart() throws InterruptedException {
        interactionHelper.clickElement(checkout_notification_bar);
//        Thread.sleep(3000);
        interactionHelper.clickElementUsingJS(shopping_cart_btn);
        interactionHelper.clickElement(termsofservice_chkBx);
        interactionHelper.clickElement(checkout_btn);
    }

}
