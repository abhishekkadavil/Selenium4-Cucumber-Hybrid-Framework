package com.dataProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

//	private ConfigFileReader(){}
//
//	static Properties properties;
//	private static final String propertyFilePath = System.getProperty("user.dir")+"/src/main/resources/Config.properties";
//
//	public static synchronized void getReader()
//	{
//		BufferedReader reader;
//		try {
//			reader = new BufferedReader(new FileReader(propertyFilePath));
//			properties = new Properties();
//			properties.load(reader);
//			reader.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
//		}
//	}
//
//
//
//	public static synchronized String getBaseUrl()
//	{
//		getReader();
//		String url = properties.getProperty("baseURL");
//		if (url != null)
//			return url;
//		else
//			throw new RuntimeException("url not specified in the Configuration.properties file.");
//	}
//
//
//
//	public synchronized static Boolean getBrowserWindowSize()
//	{
//		getReader();
//		String windowSize = properties.getProperty("BrowserWindowSize");
//		if (windowSize != null)
//			return Boolean.valueOf(windowSize);
//		return true;
//	}
//
//	public synchronized static String getBrowser()
//	{
//		getReader();
//		String browserName = properties.getProperty("browser");
//		if (browserName != null)
//			return browserName;
//		else
//			throw new RuntimeException("browserName not specified in the Configuration.properties file.");
//	}
//
//	public synchronized static String getImplicitlyWait()
//	{
//		getReader();
//		String ImplicitlyWait = properties.getProperty("ImplicitlyWait");
//		if (ImplicitlyWait != null)
//			return ImplicitlyWait;
//		else
//			throw new RuntimeException(
//					"ImplicitlyWait not specified in the Configuration.properties file for the Key: ImplicitlyWait");
//	}

}
