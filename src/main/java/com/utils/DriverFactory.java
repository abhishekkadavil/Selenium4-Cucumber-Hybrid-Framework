package com.utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	//Singleton pttern
	
	//private constructor so that no outside class can create object of this class
	private DriverFactory() {	}
	
	//to have only one copy of instance globally, hence making it static.
	private static DriverFactory DriverFactoryInstance = new DriverFactory();
	public static DriverFactory getDriverFactory() 
	{
		return DriverFactoryInstance;
		
	}
	
	//From above(line 7 to line 15), we achieved singleton design pattern i.e there will be only one instance exist ever.
	
	
	
	//factory design pattern
	ThreadLocal<WebDriver> driverList = new ThreadLocal<WebDriver>();
	
	public WebDriver getWebDriver()
	{
		return driverList.get();
	}
	
	public void setWebDriver(WebDriver driver)
	{
		driverList.set(driver);
	}
	
	public void closeBrowser()
	{
		driverList.get().close();
		driverList.get().quit();
		driverList.remove();
	}

}
