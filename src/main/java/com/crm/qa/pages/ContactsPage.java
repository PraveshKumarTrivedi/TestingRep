package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//@FindBy(xpath="//div[contains(text(),'Contacts')]")
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLable;
	
	@FindBy(xpath="//i[@class='edit icon']")
	WebElement clickOnNewicon;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement enterFName;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement enterMName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement enterLName;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement clickONSaveButton;
	
	@FindBy(xpath="//input[@type='text' and @class='search']")
	WebElement searchCompanyName;
	
	@FindBy(xpath="//i[@class='search icon']")
	WebElement clickOnSearchIcon;
	
	@FindBy(xpath="//div[@class='item']")
	WebElement clickOnComItom;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	public boolean verifyContactsLable()
	{
		return (contactsLable.isDisplayed()); 
	}
	
	public void clickOnNewContactLink()
	{
		clickOnNewicon.click();
	}
	
	public void createNewContact(String fname, String mname, String lname)
	{
		enterFName.sendKeys(fname);
		enterMName.sendKeys(mname);
		enterLName.sendKeys(lname);
		clickONSaveButton.click();
	}

}
