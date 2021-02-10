package com.qa.guruBank.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;
import com.qa.guruBank.Pages.fundTransferPage;

public class FundTransferTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	fundTransferPage fundTpage;
	
	public FundTransferTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		Intialization();
		loginpage=new LoginPage();
		fundTpage=new fundTransferPage();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		fundTpage=homepage.fundtransfer();
		
	}
	
	@Test
	public void TitleTest()
	{
		String title=fundTpage.verifyTitle();
		Assert.assertEquals(title, "Guru99 Bank Fund Transfer Entry Page");
	}
	
	@Test
	public void fundtransferpageTest()
	{
		fundTpage.veriftFundtransferpage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
