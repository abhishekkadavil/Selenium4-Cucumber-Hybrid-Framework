package com.utils;

import com.aventstack.extentreports.ExtentTest;

public class ReporterFactory {
	

		private ReporterFactory() {	}
	
		private static ReporterFactory ReporterFactoryInstance = new ReporterFactory();
		
		public static ReporterFactory getInstance() 
		{
			return ReporterFactoryInstance;
		}
		
		

		ThreadLocal<ExtentTest> extentTestList = new ThreadLocal<ExtentTest>();
		
		public ExtentTest getExtentTest()
		{
			return extentTestList.get();
		}
		
		public void setExtentTestList(ExtentTest extentTest)
		{
			extentTestList.set(extentTest);
		}
		
		public void finisheExtentTest()
		{
			extentTestList.remove();
		}

}
