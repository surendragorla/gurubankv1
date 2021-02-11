package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

import io.qameta.allure.Step;

public class EditCustomerForm extends TestBase {
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement cid;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement accSubmit;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement editphone;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement editSubmit;
	
	@FindBy(xpath="//h2[@class='barone']")
	WebElement logo;
	
	public EditCustomerForm()
	{
		PageFactory.initElements(driver, this);
	}
	@Step("Fetching the Title of the page")
	public String verifypageTitle()
	{
		return driver.getTitle();
	}
	@Step("Verify the logo is displayed or not")
	public boolean verifyeditpageLogo()
	{
		return logo.isDisplayed();
	}
	@Step("Verify the given data is updated or not")
	public void verifyEditCustomerForm()
	{
		
		cid.sendKeys("34189");
		accSubmit.click();
		editphone.clear();
		editphone.sendKeys("9573732570");
		editSubmit.click();
		
	}
	
//	public void updatePhone()
//	{
//		
//	}
	


}
