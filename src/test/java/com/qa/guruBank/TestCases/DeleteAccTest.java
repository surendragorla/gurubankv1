package com.qa.guruBank.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.DeleteAccount;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;

import com.qa.guruBank.testUtil.UtilDetails;

public class DeleteAccTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
    DeleteAccount DelACC;
    
    public DeleteAccTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		
		Intialization();
		loginpage=new LoginPage();
		DelACC=new DeleteAccount();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		DelACC=homepage.deleteAccount();
		
	}
	@Test(priority=1)
	public void TitleTest()
	{
		String title=DelACC.verifyTitle();
		Assert.assertEquals(title, "Guru99 Bank Delete Account Page");
	}
	@DataProvider
	public Object[][] getAccnofromExcel()
	{
		Object data[][]=UtilDetails.getTestdata("DelAcc");
		return data;
	}
	
	@Test(priority=2,dataProvider="getAccnofromExcel")
	public void deleteAccountTest(String AccountNo)
	{
		DelACC.verifyAccDelete(AccountNo);
		UtilDetails.alertMethod();
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
