package com.test.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.helper.ReadWriteData;
import com.test.java.BrowserSelection;
import com.test.java.HomePage;
import com.test.java.RegistrationPage;

public class TestCase {
	public WebDriver driver;
	 

	@Test
	public void CheckBrowserName(){
		
		ReadWriteData data = new ReadWriteData();
		data.LoadFile();
		String browserName = data.readBrowserName();
		String URL = data.readURL();
		
		driver = BrowserSelection.startBrowser(browserName, URL);
		
		//HomePage page = new HomePage(driver);
		HomePage page = PageFactory.initElements(driver, HomePage.class);
		
		RegistrationPage regPage = page.clickRegistrationButton(driver);
		//driver.findElement(By.id("username")).sendKeys("Swati");
		regPage.ConfirmDisplay();
		regPage.EnterFName("Swati");
		regPage.EnterLName("Verma");
		regPage.selectMaritalStatus(2);
		regPage.chooseHobby();
		regPage.SelCountry("India");
		regPage.SelMonth("11");
		regPage.SelDay("23");
		regPage.SelYear("1980");
		regPage.EnterPhoneNumber("9696969696");
		regPage.enterUserName("user-1");
		regPage.enterEmail("user-1@gmailtest.com");
		regPage.enterPwd("Testing1234!");
		regPage.enterConfPwd("Testing1234!");
		regPage.clickSubmit();
		String confirmMsg = regPage.usrCreationMsg();
		Assert.assertEquals(false, confirmMsg.equalsIgnoreCase("Thank you for your registration"));
		
	}
	
	@Test
	public void EnterRegForm(){
		
	}
}
