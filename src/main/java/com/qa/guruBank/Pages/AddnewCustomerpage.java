package com.qa.guruBank.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

public class AddnewCustomerpage extends TestBase {
	
	@FindBy(xpath="//input[@name='name']")
	WebElement cname;
	
	@FindBy(xpath="//input[@name='dob']")
	WebElement Dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement addr;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement Pincode;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement Phno;

	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath="//h2[@class='barone']")
	WebElement logo;
	

	public AddnewCustomerpage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLogo()
	{
		return logo.isDisplayed();
	}
	
	public void verifyNewContactDetails(String Cname,String DoB,String Addr,String City,String State,String Pno,
			String Mobileno,String emailid,String passwrd)
	{
		
		cname.sendKeys(Cname);
		Dob.sendKeys(DoB);
		addr.sendKeys(Addr);
		city.sendKeys(City);
		state.sendKeys(State);
		Pincode.sendKeys(Pno);
		Phno.sendKeys(Mobileno);
		email.sendKeys(emailid);
		pwd.sendKeys(passwrd);
		submit.click();
		
		
		
		
	}
	
	}
	
	


