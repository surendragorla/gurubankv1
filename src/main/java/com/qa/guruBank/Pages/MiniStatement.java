package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

import io.qameta.allure.Step;

public class MiniStatement extends TestBase {
	

	@FindBy(xpath="//input[@name='accountno']")
	WebElement accno;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	public MiniStatement()
	{
		PageFactory.initElements(driver, this);
	}
	@Step("Fetching the title of ministatement PAGE")
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	@Step("Fetching the miniStatement of given Account")
	public void verifyMinistatement()
	{
		accno.sendKeys("88123");
		submit.click();
	}

	
	

}



