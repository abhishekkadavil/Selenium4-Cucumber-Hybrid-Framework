package com.stepdef;

import com.google.inject.Inject;
import com.utils.TestContext;
import com.utils.TestDataFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @author Abhishek Kadavil
 */
public class LoginPageSteps {

    @Inject
    InteractionHelper interactionHelper;

    private By username_txtbx = By.xpath("//input[@id='Email']");
    private By password_txtbx = By.xpath("//input[@id='Password']");
    private By login_btn = By.xpath("//button[text()='Log in']");
    private By logout_btn = By.xpath("//a[@class='ico-logout']");
    private By login_error_msg = By.xpath("//div[@class='message-error validation-summary-errors']");

    @When("login using the credentials")
    public void loginUsingTheCredentials() {

        interactionHelper.typeElement(username_txtbx, TestDataFactory.getInstance().getTestDataModel().getLoginCredential().getUsername());
        interactionHelper.typeElement(password_txtbx, TestDataFactory.getInstance().getTestDataModel().getLoginCredential().getPassword());
        interactionHelper.clickElement(login_btn);
    }

    @Then("user should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        Assert.assertEquals(interactionHelper.getText(logout_btn), "Log out");
    }

    @Then("invalid user error should appear")
    public void invalidUserErrorShouldAppear() {
        Assert.assertEquals(interactionHelper.getText(login_error_msg), "Login was unsuccessful. Please correct the " +
                "errors and try again.\n" +
                "No customer account found");
    }

    @Then("{string} message should appear")
    public void invalidUserErrorShouldAppear(String message) {
        Assert.assertEquals(interactionHelper.getText(login_error_msg), message);
    }
}
