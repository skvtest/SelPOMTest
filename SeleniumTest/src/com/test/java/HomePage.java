package com.test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver ldriver){
		this.driver=ldriver;
	}

	@FindBy(id ="post-9")
	WebElement MainBox;
	
	@FindBy(xpath =".//*[@id='menu-item-374']/a")
	WebElement Registration_button;
	
	public RegistrationPage clickRegistrationButton(WebDriver Idriver){
		Registration_button.click();
		return new RegistrationPage(Idriver);
	}
}
