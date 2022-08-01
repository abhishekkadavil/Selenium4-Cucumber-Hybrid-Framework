package com.stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.utils.DriverFactory;
import com.utils.TestDataFactory;

import io.cucumber.java.en.When;

public class PaymentMethodPageSteps {
	
	
	@When("select payment method")
	public void select_payment_method() {

		String paymentType = TestDataFactory.getInstance().getTestDataModel().getPayment().getPmtType();
		
		if(paymentType.equalsIgnoreCase("Check"))
		{
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='paymentmethod_0']")).click();
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@id='payment-method-buttons-container']/button[@name='save']")).click();
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@id='payment-info-buttons-container']/button[@class='button-1 payment-info-next-step-button']")).click();
		}
		else
		{
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='paymentmethod_1']")).click();
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='CardholderName']")).sendKeys("abhishek Kadavil");
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("4001919257537193");
			
			Select sel = new Select(DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//select[@id='ExpireYear']")));
			sel.selectByIndex(3);
			
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//input[@id='CardCode']")).sendKeys("123");
			DriverFactory.getDriverFactory().getWebDriver().findElement(By.xpath("//div[@id='payment-info-buttons-container']/button[@class='button-1 payment-info-next-step-button']")).click();
		}
		
		
		
		

	}

}
