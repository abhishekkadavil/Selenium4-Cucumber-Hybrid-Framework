package com.utils;

import com.testDataModels.TestDataModel;

public class TestDataFactory {
	
	private TestDataFactory() {}
	
	private static TestDataFactory TestDataFactoryInstance = new TestDataFactory();
	
	public static TestDataFactory getInstance() 
	{
		return TestDataFactoryInstance;
	}
	
	

	ThreadLocal<TestDataModel> testDataModelList = new ThreadLocal<TestDataModel>();
	
	public TestDataModel getTestDataModel()
	{
		return testDataModelList.get();
	}
	
	public void setTestDataModel(TestDataModel testDataModel)
	{
		testDataModelList.set(testDataModel);
	}
	
	public void disposeTestDataModel()
	{
		testDataModelList.remove();
	}

}
