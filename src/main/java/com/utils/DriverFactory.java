package com.utils;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

@ScenarioScoped
public class DriverFactory {

	@Inject
	TestContext testContext;
	
	public WebDriver getBrowser(String browser, String execType)
	{
		WebDriver driver = null;

		//Suppress selenium logs
		java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.SEVERE);

		if(browser.equalsIgnoreCase("chrome"))
		{
			//Suppress chrome driver logs
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

			WebDriverManager.chromedriver().setup();
			ChromeOptions choptions = new ChromeOptions();
			choptions.addArguments("--incognito");
			if(execType.equalsIgnoreCase("local"))
			{
				driver = new ChromeDriver(choptions);
			}
			else if(execType.equalsIgnoreCase("grid")) {

				try {
					driver = (execType.equalsIgnoreCase("grid"))?
							(new RemoteWebDriver(new URL(testContext.getConfigUtil().getSeleniumGridUrl()),choptions)):
							(new ChromeDriver());
				} catch (MalformedURLException e) {
					e.printStackTrace();
					Assert.fail("MalformedURLException thrown, Grid URL is not correct");
				}

			}
			else
			{
				System.out.println("************************ execType not recognised ************************");
			}

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
