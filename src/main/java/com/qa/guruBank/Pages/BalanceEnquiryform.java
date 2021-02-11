package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

public class BalanceEnquiryform extends TestBase {
	
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement accno;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submit;
	
	public BalanceEnquiryform()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifypageTitle()
	{
		return driver.getTitle();
	}
	
	public void verifyBalEnquiry()
	{
		accno.sendKeys("34189");
		submit.click();
	}

}
