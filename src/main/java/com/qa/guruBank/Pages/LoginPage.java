package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase {
	
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement uid;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBtn;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	@Step("Fetching the title of the Page")
	public String verifyloginpageTitle()
	{
		
		return driver.getTitle();
	}
	
	
	
	
	@Step("Login with username{0} and password {1}")
	public HomePage verifyLoginDetails(String UN ,String Pwd)
	{
		uid.sendKeys(UN);
		pwd.sendKeys(Pwd);
		loginBtn.click();
		
		return new HomePage();
		
	}

}



