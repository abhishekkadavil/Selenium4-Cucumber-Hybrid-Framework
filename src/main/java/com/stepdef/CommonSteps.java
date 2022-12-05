package com.stepdef;

import com.dataproviders.JsonDataReader;
import com.utils.TestDataFactory;
import io.cucumber.java.en.Given;

public class CommonSteps {

	@Given("user is on home page and testdata present in {string}")
	public void user_is_on_home_page_and_testdata_present_in(String testDataPath) {
		testDataPath = System.getProperty("user.dir") + "/TestData/" + testDataPath;
		TestDataFactory.getInstance().setTestDataModel(JsonDataReader.getTestData(testDataPath));
	}

}
