package com.stepdef;

import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

/**
 * @author Abhishek Kadavil
 */
public class BillingAddressPageSteps {

    @Inject
    InteractionHelper interactionHelper;

    private By billing_address_save_btn = By.xpath("//div[@id='billing-buttons-container']/button[@name='save']");
    private By billing_address_country_sel = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private By billing_address_state_sel = By.xpath("//select[@id='BillingNewAddress_StateProvinceId']");
    private By billing_address_city_txtbx = By.xpath("//input[@id='BillingNewAddress_City']");
    private By billing_address_address1_txtbx = By.xpath("//input[@id='BillingNewAddress_Address1']");
    private By billing_address_pincode_txtbx = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private By billing_address_phoneno_txtbx = By.xpath("//input[@id" +
            "='BillingNewAddress_PhoneNumber']");

    @When("select billing address")
    public void select_billing_address() {

        interactionHelper.clickElement(billing_address_save_btn);
    }

    @And("add billing address")
    public void add_billing_address() {

        interactionHelper.selectElementByText(billing_address_country_sel, "India");
        interactionHelper.selectElementByText(billing_address_state_sel, "Kerala");
        interactionHelper.typeElement(billing_address_city_txtbx, "Therissuer");
        interactionHelper.typeElement(billing_address_address1_txtbx, "Kadaveeil House, Palakakal");
        interactionHelper.typeElement(billing_address_pincode_txtbx, "680027");
        interactionHelper.typeElement(billing_address_phoneno_txtbx, "09946266913");
        interactionHelper.clickElement(billing_address_save_btn);

    }

}
