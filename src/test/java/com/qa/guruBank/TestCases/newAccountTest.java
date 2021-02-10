package com.qa.guruBank.TestCases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;
import com.qa.guruBank.Pages.NewAccount;
import com.qa.guruBank.testUtil.UtilDetails;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class newAccountTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	NewAccount Nacc;
	public newAccountTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		
		Intialization();
		loginpage=new LoginPage();
		Nacc=new NewAccount();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		Nacc=homepage.createNewAccount();
		
		
		
	}
	@Test(priority=1,description="verifying NewAccount page title")
	@Description("The Test Case helps me to validate the NewAccount page Title")
	@Severity(SeverityLevel.NORMAL)	
	@Story("[JIRA.1345],This Stroy Checks the created new Account or not....")
	@Feature("Verify newAccount page Title")
	public void TitleTest()
	{
		String Title=Nacc.verifyTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Guru99 bank add new account");
	}
	@DataProvider()
	public Object[][] getAccData()
	{
		Object data[][]=UtilDetails.getTestdata("NewAccount");
		return data;
	}
	@Test(priority=2,dataProvider="getAccData")
	@Description("The Test Case helps me to verify the NewAccount Added or not...")
	@Severity(SeverityLevel.CRITICAL)	
	@Story("[JIRA.1345],This Stroy Checks the created new Account or not....")
	@Feature("Verify newAccount created or not")
	public void newAccountCreateTest(String CustID,String Deposite)
	{
		Nacc.verifyNewAccountForm(CustID,Deposite);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	


}
