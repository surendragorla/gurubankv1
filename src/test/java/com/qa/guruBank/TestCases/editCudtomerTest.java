package com.qa.guruBank.TestCases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.Pages.EditCustomerForm;
import com.qa.guruBank.Pages.HomePage;
import com.qa.guruBank.Pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class editCudtomerTest extends TestBase {

	
	LoginPage loginpage;
	HomePage homepage;
	EditCustomerForm editcusform;
	
	public editCudtomerTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		Intialization();
		loginpage=new LoginPage();
		editcusform=new EditCustomerForm();
		homepage=loginpage.verifyLoginDetails(prop.getProperty("UserName"),prop.getProperty("PassWord"));
		editcusform=homepage.editCustomer();
	}
	
	@Test(priority=1,description="verifying EditCustomer page Title")
	@Description("The Test Case helps me to validate the EditCustomer page Title")
	@Severity(SeverityLevel.NORMAL)	
	@Story("[JIRA.1347],This Stroy Checks the EditCustomer page Title")
	@Feature("Validate Edit Customer Page Title")
	public void titleTest()
	{
		String title=editcusform.verifypageTitle();
		System.out.println(title);
		Assert.assertEquals(title, " Guru99 Bank Edit Customer Page");
	}
	
	@Test(priority=2,description="verifying EditCustomer page Logo")
	@Description("The Test Case helps me to validate the EditCustomer page Logo")
	@Severity(SeverityLevel.NORMAL)	
	@Story("[JIRA.1347],This Stroy Checks the EditCustomer page Logo")
	@Feature("Validate Edit Customer Page Logo")
	public void EditcustformLogoTest()
	{
		
	 boolean logo=editcusform.verifyeditpageLogo();
	 Assert.assertTrue(logo);
	}
	
	@Test(priority=3,description="verifying EditCustomer Data")
	@Description("The Test Case helps me to verify the EditCustomer page Data")
	@Severity(SeverityLevel.CRITICAL)	
	@Story("[JIRA.1347],This Stroy Checks the EditCustomer page Data")
	@Feature("Validate Edit Customer Page Data")
	public void EditCustomerDataTest() throws InterruptedException
	{
		editcusform.verifyEditCustomerForm();
		Thread.sleep(3000);
		//editcusform.updatePhone();
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
}
