package com.test.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	WebDriver driver;

	public RegistrationPage(WebDriver ldriver) {
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(id = "primary")
	WebElement RegistrationBox;
	
	@FindBy(id="name_3_firstname" )
	WebElement FirstName;
	
	@FindBy(id="name_3_lastname" )
	WebElement LastName;
	
	@FindBy(xpath=".//*[@id='pie_register']/li[2]/div/div/input")
	List<WebElement> MaritalStatus;
	
	
	@FindBy(xpath=".//*[@id='pie_register']/li[3]/div/div/input")
	List<WebElement> Hobby;
	
	@FindBy(id="dropdown_7" )
	WebElement CountryName;
	
	@FindBy(id="mm_date_8" )
	WebElement Month;
	
	@FindBy(id="dd_date_8" )
	WebElement Day;
	
	@FindBy(id="yy_date_8" )
	WebElement Year;
	
	@FindBy(id="phone_9" )
	WebElement PhoneNumber;
	
	@FindBy(id="username" )
	WebElement UserName;
	
	@FindBy(id="email_1" )
	WebElement email;
	
	@FindBy(id="password_2" )
	WebElement Pwd;
	
	@FindBy(id="confirm_password_password_2" )
	WebElement ConfirmPwd;
	
	@FindBy(xpath=".//*[@id='pie_register']/li[14]/div/input")
	WebElement Submit_btn;
	
	@FindBy(xpath=".//*[@id='post-49']/div/p")
	WebElement UserCreationConfirmMessage;
	
	public void selectMaritalStatus(int index){
		List<WebElement> list = MaritalStatus;
		list.get(index).click();
	}
	
	public void chooseHobby(){
		List<WebElement> list = Hobby;
		for(WebElement item : list){
			if(!item.isSelected())
				item.click();
		}
	}
	
	public void SelCountry(String countryName){
		Select sel = new Select(CountryName);
		sel.selectByVisibleText(countryName);
	}
	
	public void SelMonth(String month){
		Select sel = new Select(Month);
		sel.selectByValue(month);
	}
	
	public void SelDay(String day){
		Select sel = new Select(Day);
		sel.selectByValue(day);
	}
	
	public void SelYear(String year){
		Select sel = new Select(Year);
		sel.selectByValue(year);
	}
	
	public void EnterPhoneNumber(String Number){
		PhoneNumber.sendKeys(Number);
	}
	
	public void EnterFName(String FName){
		//this.driver.findElement(FirstName).sendKeys(FName);
		FirstName.sendKeys(FName);
	}
	
	public void EnterLName(String LName){
		LastName.sendKeys(LName);
	}
	
	public void enterUserName(String usrName){
		UserName.sendKeys(usrName);
	}
	
	public void enterEmail(String Email){
		email.sendKeys(Email);
	}
	
	public void enterPwd(String pwd){
		Pwd.sendKeys(pwd);
	}
	
	public void enterConfPwd(String confPwd){
		ConfirmPwd.sendKeys(confPwd);
	}
	
	public void clickSubmit(){
		Submit_btn.click();
	}
	
	public boolean ConfirmDisplay() {
		return this.RegistrationBox.isDisplayed();
	}
	
	public String usrCreationMsg(){
		return UserCreationConfirmMessage.getText();
	}
}
