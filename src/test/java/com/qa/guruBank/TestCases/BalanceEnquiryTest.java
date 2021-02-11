package com.qa.guruBank.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.BalanceEnquiryform;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;
import com.qa.guruBank.testUtil.UtilDetails;

public class BalanceEnquiryTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	BalanceEnquiryform balenqiry;
	
	public BalanceEnquiryTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		Intialization();
		loginpage=new LoginPage();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"), prop.getProperty("PassWord"));
		balenqiry=homepage.clickBalEnquiry();
	}
	
	@Test
	public void TitleTest()
	{
		String title=balenqiry.verifypageTitle();
		Assert.assertEquals(title, "Guru99 Bank Balance Enquiry Page");
	}
	
	@DataProvider()
	public Object[][] getAccno()
	{
		Object[][]data=UtilDetails.getTestdata("BalEnq");
		return data;
	}
	
	@Test(dataProvider="getAccno")
	public void BalenquiryTest(String Accno)
	{
		balenqiry.verifyBalEnquiry(Accno);
		
		UtilDetails.alertMethod();
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	

}
