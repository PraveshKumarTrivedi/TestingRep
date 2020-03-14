package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	

	//Page Factory = OR
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement loginIcon;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement clickOnSubmit;
	
	@FindBy(xpath="//span[contains(text(),'free')]")
	WebElement crmlogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);// here i can user "this" keyword in place "LoginPage.class"
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmlogo.isDisplayed();
	}
	public HomePage login(String un, String pwd)
	{
		loginIcon.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		clickOnSubmit.click();
		return new HomePage();// Because after login it will land to HOME PAGE that is why we use home page 
	}
}
