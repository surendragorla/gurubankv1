package com.qa.guruBank.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;
import com.qa.guruBank.testUtil.UtilDetails;

public class EditAccForm extends TestBase {
	
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement ACCno;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement Submit;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submit1;
	
	public EditAccForm()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public void verifyEditAccForm()
	{
		ACCno.sendKeys("89548");
		Submit.click();
		submit1.click();
		
		Alert alert=driver.switchTo().alert();
		String alrtMsg=driver.switchTo().alert().getText();
		System.out.println(alrtMsg);
		alert.accept();
	}

}
