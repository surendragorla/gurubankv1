package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

public class CustomizedStatementpage extends TestBase {
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement Accno;
	
	@FindBy(xpath="//input[@name='fdate']")
	WebElement fromDate;
	
	@FindBy(xpath="//input[@name='tdate']")
	WebElement toDate;
	
	@FindBy(xpath="//input[@name='amountlowerlimit']")
	WebElement miniTransAmount;
	
	@FindBy(xpath="//input[@name='numtransaction']")
	WebElement noofTransactions;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submit;

	public  CustomizedStatementpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyStatementPageTitle()
	{
		return driver.getTitle();
	}
	
	public void verifyCustomizedStatPage()
	{
		Accno.sendKeys("87358");
		fromDate.sendKeys("11/20/2020");
		toDate.sendKeys("12/03/2020");
		miniTransAmount.sendKeys("500");
		noofTransactions.sendKeys("10");
		submit.click();
	}
	
	
//	public void fromdate() {
//		
//		String month="November 2020";
//		fromDate.click();
//		
//		while(true)
//		{
//			String monthtext=
//		}
//		
//	}
	
	
	
	
	

}
