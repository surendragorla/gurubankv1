package com.qa.guruBank.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginTest extends TestBase {
	
	
	LoginPage loginpage;
    HomePage homepage;
    
    public LoginTest()
    {
    	super();
    }
	
	@BeforeMethod
	public void setUp()
	{
		
		Intialization();
		loginpage=new LoginPage(); 
		
	}
	
	@Test(priority=1,description="verifying login page title")
	@Description("The Test Case helps me to validate the Login page Title")
	@Severity(SeverityLevel.NORMAL)	
	@Story("[JIRA.1345],This Stroy Checks the basic WebElements in the webpages")
	@Feature("Validate webpage Title")
	public void LoginpageTitleTest()
	{
		String LoginTitle=loginpage.verifyloginpageTitle();
		System.out.println("LoginPageTitle="+LoginTitle);
		Assert.assertEquals(LoginTitle, "Guru99 Bank Home Page");
	}
	
	@Test(priority=2,description="verifying login page Login Credentials...")
	@Description("The Test case Helps me to validate the Login Credentials...")
	@Severity(SeverityLevel.BLOCKER)
	@Story("[JIRA.1345],This Stroy Checks the basic WebElements in the webpages")
	@Feature("Login to webpage")
	public void LoginDetailsTest()
	{
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}



