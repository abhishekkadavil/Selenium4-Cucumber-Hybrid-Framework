package com.stepdef;

import com.google.inject.Inject;
import com.utils.TestDataFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterUser {

    @Inject
    InteractionHelper interactionHelper;

    private By register_btn = By.xpath("//a[text()='Register']");
    private By gender_btn = By.xpath("//input[@id='gender-male']");
    private By first_name_txtBx = By.xpath("//input[@id='FirstName']");
    private By last_name_txtBx = By.xpath("//input[@id='LastName']");
    private By DateOfBirthDay_sel = By.xpath("//select[@name='DateOfBirthDay']");
    private By DateOfBirthMonth_sel = By.xpath("//select[@name='DateOfBirthMonth']");
    private By DateOfBirthYear_sel = By.xpath("//select[@name='DateOfBirthYear']");
    private By email_txtBx = By.xpath("//input[@id='Email']");
    private By company_txtBx = By.xpath("//input[@id='Company']");
    private By password_txtBx = By.xpath("//input[@id='Password']");
    private By confirmPassword_txtBx = By.xpath("//input[@id='ConfirmPassword']");
    private By register_user_btn = By.xpath("//button[@id='register-button']");
    private By logout_btn = By.xpath("//a[text()='Log out']");
    private By reg_result = By.xpath("//div[@class='result']");

    @When("navigate to register user page")
    public void navigate_to_register_user_page() {
        interactionHelper.clickElement(register_btn);
    }
    @And("add personal details")
    public void add_personal_details() {
        interactionHelper.clickElement(gender_btn);
        interactionHelper.typeElement(first_name_txtBx,"Jhone");
        interactionHelper.typeElement(last_name_txtBx,"Kadavil");
        interactionHelper.selectElementByText(DateOfBirthDay_sel,"27");
        interactionHelper.selectElementByText(DateOfBirthMonth_sel,"May");
        interactionHelper.selectElementByText(DateOfBirthYear_sel,"1993");
        interactionHelper.typeElement(email_txtBx, TestDataFactory.getInstance().getTestDataModel().getLoginCredential().getUsername());
    }
    @And("add company details")
    public void add_company_details() {
        interactionHelper.typeElement(company_txtBx,"QBurstosis");
    }
    @And("add options")
    public void add_options() {    }
    @And("add password")
    public void add_password() {
        interactionHelper.typeElement(password_txtBx,
                TestDataFactory.getInstance().getTestDataModel().getLoginCredential().getPassword());
        interactionHelper.typeElement(confirmPassword_txtBx,TestDataFactory.getInstance().getTestDataModel().getLoginCredential().getPassword());
    }
    @And("user should be able register successfully")
    public void user_should_be_able_register_successfully() {

        interactionHelper.clickElement(register_user_btn);
        Assert.assertEquals(interactionHelper.getText(reg_result),"Your registration completed");
        interactionHelper.clickElement(logout_btn);
    }

}
