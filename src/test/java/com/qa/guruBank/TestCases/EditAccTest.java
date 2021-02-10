package com.qa.guruBank.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.EditAccForm;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;
import com.qa.guruBank.testUtil.UtilDetails;

public class EditAccTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	EditAccForm edtaccform;
	
	public  EditAccTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Intialization();
		loginpage=new LoginPage();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		edtaccform=homepage.clickEditAccount();
		
	}
	
	@Test(priority=2)
	public void TitleTest()
	{
		String title=edtaccform.verifyPageTitle();
		Assert.assertEquals(title, "Guru99 Edit Account Page");
	}
	
	@Test(priority=1)
	public void EditAccFormTest()
	{
		
		edtaccform.verifyEditAccForm();
		
		
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
//	
	

}
