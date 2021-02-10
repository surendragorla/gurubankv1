package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

public class AmountDepositForm extends TestBase {
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement accno;
	
	@FindBy(xpath="//input[@name='ammount']")
	WebElement Amt;
	
	@FindBy(xpath="//input[@name='desc']")
	WebElement Descr;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submit;
	
	@FindBy(xpath="//img[@alt='Guru99 Demo Sites']")
	WebElement logo;
	
	public AmountDepositForm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public void getDepositData(String AccNo,String Amount,String Desc)
	{
		accno.sendKeys(AccNo);
		Amt.sendKeys(Amount);
		Descr.sendKeys(Desc);
		submit.click();
		
	}
	

}
