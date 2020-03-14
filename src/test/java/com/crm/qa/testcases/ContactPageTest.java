package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	public ContactPageTest()
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
		contactspage = homepage.clickOnContactsLink();
		testutil = new TestUtil();
	}
/*	@Test
	public void verifyContatsPageLableTest() throws InterruptedException
	{
		Assert.assertTrue(contactspage.verifyContactsLable(),"contacts lable is missing on page");
	}
		*/
	@DataProvider
	public Object[][] getTestCRMData()
	{
		Object [][] data = TestUtil.getTestData("contacts");
		return data;
	}
	@Test(dataProvider = "getTestCRMData")
	public void validateNewContact(String FirstName, String MiddleName, String LastName) throws InterruptedException
	{
		contactspage.clickOnNewContactLink();
		//contactspage.createNewContact("TOM","DEN","MOORAY");
		contactspage.createNewContact(FirstName,MiddleName,LastName);
		Thread.sleep(10000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
