package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
		contactspage = new ContactsPage();
	}
	// Test cases should be separated -- independent with each other
	// before each test case launch the Browser and after each test case close the browser
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String hometitle = homepage.verifyTitleOfPage();
		Assert.assertEquals(hometitle,"Cogmento CRM","Home page tile not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test
	public void verifyContactsLinkTest()
	{
		contactspage = homepage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
