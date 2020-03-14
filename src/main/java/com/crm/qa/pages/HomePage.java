package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
		
	@FindBy(xpath="//span[contains(text(),'Pravesh Trivedi')]")
	WebElement usernamelable;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasklink;

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleOfPage()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		return usernamelable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactslink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealLink()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasklink.click();
		return new TasksPage();
	}
}
