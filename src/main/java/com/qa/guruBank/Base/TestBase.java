package com.qa.guruBank.Base;

import java.io.FileInputStream;




import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.guruBank.testUtil.UtilDetails;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\sys\\eclipse-workspace\\guruBank\\src\\main\\java\\com\\qa\\guruBank\\Config\\config.Properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Intialization()
	{
		
		String BrowserName=prop.getProperty("Browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sys\\Downloads\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(BrowserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumDrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(UtilDetails.PAGE_LOAD_TIME, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(UtilDetails.IMPLICITE_TIME, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.get(prop.getProperty("Url"));
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	

}
