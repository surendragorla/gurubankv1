package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.guruBank.Base.TestBase;

import io.qameta.allure.Step;

public class NewAccount extends TestBase {
	

	@FindBy(xpath="//input[@name='cusid']")
	WebElement custID;
	
	@FindBy(xpath="//select[@name='selaccount']")
	WebElement drop;
	
	@FindBy(xpath="//input[@name='inideposit']")
	WebElement deposite;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	public NewAccount()
	{
		PageFactory.initElements(driver, this);
	}
	
	@Step("Verify the Title")
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
   @Step("Verify the newAccount with CustomerID{0} and depositeAmount{1}...")
	public void verifyNewAccountForm(String cid,String dps)
	{
	    
		custID.sendKeys(cid);
		Select drop1=new Select(drop);
		drop1.selectByIndex(0);
		deposite.sendKeys(dps);
		submit.click();
				
		
	}
	

	

}
