package com.stepdef;

import com.google.inject.Inject;
import com.testdatamodels.Item;
import com.utils.ScenarioContext;
import com.factories.TestDataFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

/**
 * @author Abhishek Kadavil
 */
public class ItemPageSteps {

    @Inject
    InteractionHelper interactionHelper;
    @Inject
    ScenarioContext scenarioContext;

    private By item_quantity_txtbx = By.xpath("//input[@aria-label='Enter a quantity']");
    private By add_to_cart_btn = By.xpath("//button[@class='button-1 add-to-cart-button']");

    @When("add item to cart")
    public void add_item_to_cart() {

        for (Item item : TestDataFactory.getInstance().getTestDataModel().getItems()) {

            //navigate to each item through url
            scenarioContext.getDriver().navigate().to(item.getUrl());

            interactionHelper.typeElement(item_quantity_txtbx, item.getQuantity());
            interactionHelper.clickElement(add_to_cart_btn);
        }

    }

}
