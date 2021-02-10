package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

public class DeleteAccount extends TestBase {
	
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement Accno;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement Submit;
	
	public DeleteAccount()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public void verifyAccDelete(String accNo)
	{
		Accno.sendKeys(accNo);
		Submit.click();
	}

}
