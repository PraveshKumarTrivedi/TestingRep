package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title =loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	@Test(priority=2)
	public void validationCRMImageTest()
	{
		boolean value = loginpage.validateCRMImage();
		Assert.assertTrue(value);
	}
	@Test(priority=3)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
