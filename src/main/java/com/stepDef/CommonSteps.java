package com.stepDef;

import com.dataProviders.JsonDataReader;
import com.utils.TestContext;
import com.utils.TestDataFactory;

import io.cucumber.java.en.Given;

public class CommonSteps {
	
	private TestContext testContext;
	
	public CommonSteps(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@Given("user is on home page and testdata present in {string}")
	public void user_is_on_home_page_and_testdata_present_in(String testDataPath) {

		testDataPath = System.getProperty("user.dir") + "/TestData/" + testDataPath;
		TestDataFactory.getInstance().setTestDataModel(JsonDataReader.getTestData(testDataPath));
	}

}
