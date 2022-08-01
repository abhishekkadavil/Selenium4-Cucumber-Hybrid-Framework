package test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public static void main(String[] args) throws IOException {
		System.out.println("hi singam");
		
//		// Passing the path to the file as a parameter
//        FileReader fr = new FileReader(
//            "/home/qbuser/FR-Payment/00 IIT Automation/fr-payment-integration-test/src/test/resources/testdata/api/bluegate/scenario1/requestBody.txt");
// 
//        // Declaring loop variable
//        int i;
//        // Holds true till there is nothing to read
//        while ((i = fr.read()) != -1)
// 
//            // Print all the content of a file
//            System.out.print((char)i);
//        
//        fr.close();
		
//		String content = new String(Files.readAllBytes(Paths.get("/home/qbuser/FR-Payment/00 IIT Automation/fr-payment-integration-test/src/test/resources/testdata/api/bluegate/scenario1/requestBody.txt")));
//		System.out.println(content);
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		// Navigate to the demoqa website
		driver.get("https://www.demoqa.com");
		
		driver.quit();

	}

}
