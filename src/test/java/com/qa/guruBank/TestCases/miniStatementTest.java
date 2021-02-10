package com.qa.guruBank.TestCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;
import com.qa.guruBank.Pages.MiniStatement;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class miniStatementTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	MiniStatement mstat;
	
	public miniStatementTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		Intialization();
		loginpage=new LoginPage();
		mstat=new MiniStatement();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		mstat=homepage.takeMiniStatement();
		
		
	}
	
	@Test
	@Description("The Test Case helps me to verify the Title of the MinistatementPage...")
	@Severity(SeverityLevel.NORMAL)	
	@Story("[JIRA.1345],This Stroy Checks the MiniStatement Page Title....")
	@Feature("Verify Title for Ministatement Page")
	public void titleTest()
	{
		String title=mstat.verifyTitle();
		Assert.assertEquals(title, "Guru99 Bank Mini Statement Page");
	}
	
	@Test
	@Description("The Test Case helps me to verify the  Ministatement of our Account...")
	@Severity(SeverityLevel.NORMAL)	
	@Story("[JIRA.1345],This Stroy Checks the MiniStatement of existing Account....")
	@Feature("Verify Ministatement of the Given Account ")
	public void testMini()
	{
		mstat.verifyMinistatement();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
