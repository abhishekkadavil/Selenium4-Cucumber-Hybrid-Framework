package com.stepdef;

import com.google.inject.Inject;
import com.utils.TestDataFactory;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class PaymentMethodPageSteps {
	@Inject
	InteractionHelper interactionHelper;

	private By paymentMethod_check_btn = By.xpath("//input[@id='paymentmethod_0']");
	private By paymentMethod_save_btn = By.xpath("//div[@id='payment-method-buttons-container']/button[@name='save']");
	private By payment_info_next_btn = By.xpath("//div[@id='payment-info-buttons-container']/button[@class='button-1 " +
			"payment-info-next-step-button']");
	private By paymentMethod_card_btn = By.xpath("//input[@id='paymentmethod_1']");
	private By cardHolderName_txtBx = By.xpath("//input[@id='CardholderName']");
	private By cardNumber_txtBx = By.xpath("//input[@id='CardNumber']");
	private By cardExpiryDate_year_sel = By.xpath("//select[@id='ExpireYear']");
	private By cardCode_txtBx = By.xpath("//input[@id='CardCode']");

	@When("select payment method")
	public void select_payment_method() {

		String paymentType = TestDataFactory.getInstance().getTestDataModel().getPayment().getPmtType();
		
		if(paymentType.equalsIgnoreCase("Check"))
		{
			interactionHelper.clickElement(paymentMethod_check_btn);
			interactionHelper.clickElement(paymentMethod_save_btn);
			interactionHelper.clickElement(payment_info_next_btn);
		}
		else
		{
			interactionHelper.clickElement(paymentMethod_card_btn);
			interactionHelper.typeElement(cardHolderName_txtBx,"gsadsad Kadavil");
			interactionHelper.typeElement(cardNumber_txtBx,"4001919257537193");

			interactionHelper.selectElementByIndex(cardExpiryDate_year_sel,3);

			interactionHelper.typeElement(cardCode_txtBx,"123");
			interactionHelper.clickElement(payment_info_next_btn);
		}

	}

}
