package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.testUtil.UtilDetails;

public class fundTransferPage extends TestBase {
	
	
	@FindBy(xpath="//input[@name='payersaccount']")
	WebElement payersAccNo;
	
	@FindBy(xpath="//input[@name='payeeaccount']")
	WebElement payeesAccNo;
	
	@FindBy(xpath="//input[@name='ammount']")
	WebElement Amount;
	
	@FindBy(xpath="//input[@name='desc']")
	WebElement desc;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submit;
	
	public fundTransferPage()
	{
		PageFactory.initElements(driver, this);
	}
	
//	public String verifyTitle()
//	{
//		return driver.getTitle();
//	}
	
public String verifyTitle() {
		
		return driver.getTitle();
		
	}

	public void veriftFundtransferpage()
	{
		payersAccNo.sendKeys("89458");
		payeesAccNo.sendKeys("89459");
		Amount.sendKeys("500");
		desc.sendKeys("personal");
		submit.click();
		UtilDetails.alertMethod();
		
	}

	

	


}
