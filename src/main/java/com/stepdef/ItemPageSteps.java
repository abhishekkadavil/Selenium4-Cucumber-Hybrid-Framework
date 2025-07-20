package com.stepdef;

import com.dataproviders.TestDataReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.utils.ScenarioContext;
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
    @Inject
    TestDataReader testDataReader;

    private By item_quantity_txtbx = By.xpath("//input[@aria-label='Enter a quantity']");
    private By add_to_cart_btn = By.xpath("//button[@class='button-1 add-to-cart-button']");

    @When("add item to cart")
    public void add_item_to_cart() {

        JsonNode itemsNode = testDataReader.getItems();
        if (itemsNode != null && itemsNode.isArray()) {
            for (JsonNode item : itemsNode) {
                String url = item.get("url").asText();
                String size = item.get("size").asText();
                String quantity = item.get("quantity").asText();

                // Use the values
                scenarioContext.getDriver().navigate().to(url);
                interactionHelper.typeElement(item_quantity_txtbx, quantity);
                interactionHelper.clickElement(add_to_cart_btn);
            }
        }

    }

}
