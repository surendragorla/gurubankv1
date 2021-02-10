package com.qa.guruBank.TestCases;

import org.testng.Assert;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.AddnewCustomerpage;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;
import com.qa.guruBank.testUtil.UtilDetails;

public class AddNewCustomerTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	AddnewCustomerpage newCustomer;
	
	public AddNewCustomerTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{ 
		Intialization();
		loginpage=new LoginPage();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		newCustomer=homepage.verifyNewCustomerLink();
	}
	
	@Test
    public void titleTest()
    {
		String Title=newCustomer.verifyTitle();
		Assert.assertEquals(Title, "Guru99 Bank New Customer Entry Page");
	}
	@Test(priority=1)
	public void NewCustomerLogoTest()
	{
		boolean logo=newCustomer.verifyLogo();
		Assert.assertTrue(logo);
		
	}
	
	@DataProvider()
	public Object[][] getnewCustomerData()
	{
		Object data[][]=UtilDetails.getTestdata("CustomerDetails");
		return data;
	}

	@Test(priority=2,dataProvider="getnewCustomerData")
	public void AddCustomerTest(String CustomerName,String Dob ,String Address,String City,String State,String PinCode,
			String MobileNo,String Email,String Password) throws InterruptedException
	{
		Thread.sleep(3000);
		
		
		
		
		newCustomer.verifyNewContactDetails(CustomerName,Dob, Address, City, State, PinCode, MobileNo, Email,Password);
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
