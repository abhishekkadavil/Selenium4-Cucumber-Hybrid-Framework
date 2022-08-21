package com.utils;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

@ScenarioScoped
public class BrowserFactory {
	
	public WebDriver getBrowser(String browser)
	{
		WebDriver driver = null;
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions choptions = new ChromeOptions();
			choptions.addArguments("--incognito");
			driver = new ChromeDriver(choptions);
			
			//to limit timeout message in console
			//System.setProperty("webdriver.chrome.SilentOutput", true);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");
			driver = new FirefoxDriver(foptions);
		}
		
		return driver;
		
	}

}
