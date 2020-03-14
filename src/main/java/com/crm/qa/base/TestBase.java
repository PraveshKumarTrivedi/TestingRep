package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static	Properties prop;
	
	static EventFiringWebDriver e_driver;
	static WebEventListener eventListner;
	
	public TestBase()
	{
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:/newworkspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListner = new WebEventListener();
		e_driver.register(eventListner);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LONG_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url")); 
	}

}
