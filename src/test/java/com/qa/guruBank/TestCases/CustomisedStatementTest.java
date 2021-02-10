package com.qa.guruBank.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.CustomizedStatementpage;

import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;

public class CustomisedStatementTest extends TestBase {
	
	
	LoginPage loginpage;
    HomePage homepage;
    CustomizedStatementpage cstpage;
	public CustomisedStatementTest()
	{
		super();
	}
	@BeforeMethod()
	public void setUp() throws InterruptedException
	{
		Intialization();
		loginpage=new LoginPage();
		cstpage=new  CustomizedStatementpage();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		cstpage=homepage.CustomizedStatement();
	}
	@Test
	public void TitleTest()
	{
		String title=cstpage.verifyStatementPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Statement Page");
	}
	@Test
	public void statementpageTest()
	{
		cstpage.verifyCustomizedStatPage();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
