package com.stepDef;

import com.utils.DriverFactory;
import com.utils.TestContext;
import com.utils.TestDataFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
public class LoginPageSteps {
	
	TestContext testContext;
	
	public void LoginPageSteps(TestContext testContext) 
	{
		this.testContext = testContext;
	}

	@When("login using the credentials")
	public void loginUsingTheCredentials() {

		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='Email']")).sendKeys(TestDataFactory.getInstance().getTestDataModel().getLogin_credentail().getUsername());
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='Password']")).sendKeys(TestDataFactory.getInstance().getTestDataModel().getLogin_credentail().getPassword());
		DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//button[text()='Log in']")).click();
	}

	@Then("user should be able to login successfully")
	public void userShouldBeAbleToLoginSuccessfully() {
		Assert.assertEquals(DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//a[@class='ico-logout']")).getText(),"Log out");
	}

	@Then("invalid user error should appear")
	public void invalidUserErrorShouldAppear() {
		Assert.assertEquals(DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText(),"Login was unsuccessful. Please correct the errors and try again.\n" +
				"No customer account found");
	}
}
