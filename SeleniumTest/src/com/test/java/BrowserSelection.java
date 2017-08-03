package com.test.java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BrowserSelection {
	
	static WebDriver driver;
	@BeforeTest
	public static WebDriver startBrowser(String browserName, String URL){
		if(browserName.equalsIgnoreCase("FireFox")){
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D://swati//chromedriver.exe");
			ChromeOptions o = new ChromeOptions();
			o.addArguments("disable-extensions");
			o.addArguments("--start-maximized");

			driver = new ChromeDriver();
		}else 
			System.out.println("Browser with the given browser name does not supports:");
		
		//driver.manage().window().maximize();
		driver.get(URL);
		
		return driver;
	}
	
	@AfterTest
	public static void closeBrowser(){
		driver.close();
	}
}
