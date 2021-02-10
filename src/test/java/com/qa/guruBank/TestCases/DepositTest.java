package com.qa.guruBank.TestCases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.AddnewCustomerpage;
import com.qa.guruBank.Pages.AmountDepositForm;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;
import com.qa.guruBank.testUtil.UtilDetails;

public class DepositTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	AddnewCustomerpage newCustomer;
	AmountDepositForm amtdeposite;
	
	public DepositTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setUp()
	{
		Intialization();
		loginpage=new LoginPage();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		newCustomer=homepage.verifyNewCustomerLink();
		amtdeposite=homepage.deposit();
	}
	
	@Test(priority=1)
	public void TitleTest()
	{
		String Title=amtdeposite.verifyPageTitle();
		Assert.assertEquals(Title, "Guru99 Bank Amount Deposit Page");
	}
	@Test(priority=2)
	public void logoTest()
	{
		boolean logo=amtdeposite.verifyLogo();
		Assert.assertTrue(logo);
	}
	@DataProvider()
	public Object[][] getdataFromExcel()
	{
		Object data[][]=UtilDetails.getTestdata("Deposit");
		return data;
	}
	@Test(priority=3,dataProvider="getdataFromExcel")
	public void amtDepositTest(String AccNo,String Amount,String Desc) throws InterruptedException
	{
		Thread.sleep(3000);
		
		amtdeposite.getDepositData(AccNo,Amount,Desc);
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
