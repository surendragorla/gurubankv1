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

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		Intialization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		
		
	}
	
	@Test(priority=1,description="Verifying home Page Title...")
	@Description("The Test Case helps me to validate the Home page Title...")
	@Severity(SeverityLevel.CRITICAL)	
	@Story("[JIRA.1346],This Stroy Checks the basic WebElements in the Homepage...")
	@Feature("Validate Home Page Title...")
	public void homepageTitleTest() throws InterruptedException
	{
		Thread.sleep(3000);
	       String Title=homepage.verifyhomepagetitle();
		
		Assert.assertEquals(Title, "Guru99 Bank Manager HomePage");
		//System.out.println(Title);
	}
	
	@Test(priority=2,description="Verifying the newCustomer Link")
	@Description("The Test Case helps me to verifying  the NewCustomer Link.....  ")
	@Severity(SeverityLevel.CRITICAL)	
	@Story("[JIRA.1346],This Stroy Checks the basic WebElements in the Homepage")
	@Feature("Verifying newCustomer Link.....")
	public void NewCustomerTest() throws InterruptedException
	{
		Thread.sleep(3000);
		homepage.verifyNewCustomerLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
