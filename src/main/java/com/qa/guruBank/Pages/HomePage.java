package com.qa.guruBank.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guruBank.Base.TestBase;

import io.qameta.allure.Step;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newCustomer;
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement EditCustomer;
	
	@FindBy(xpath="//a[contains(text(),'New Account')]")
	WebElement newAccount;
	
	@FindBy(xpath="//a[contains(text(),'Mini Statement')]")
	WebElement miniStatement;
	
	@FindBy(xpath="//a[contains(text(),'Delete Account')]")
	WebElement deleteAcc;
	
	@FindBy(xpath="//a[contains(text(),'Customised Statement')]")
	WebElement CustStatement;
	
	@FindBy(xpath="//a[contains(text(),'Deposit')]")
	WebElement Deposit;
	
	@FindBy(xpath="//a[contains(text(),'Fund Transfer')]")
	WebElement fundtransfer;
	
	@FindBy(xpath="//a[contains(text(),'Balance Enquiry')]")
	WebElement balenq;
	
	@FindBy(xpath="//a[contains(text(),'Edit Account')]")
	WebElement editAcc;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@Step("Verify the Home page title")
	public String verifyhomepagetitle()
	{
		return driver.getTitle();
	}
	@Step("Verify New Customer Link")
	public AddnewCustomerpage verifyNewCustomerLink()
	{
		newCustomer.click();
		
		return new AddnewCustomerpage();
	}
	@Step("Verify EditCustomer Form Link")
	public EditCustomerForm editCustomer()
	{
		EditCustomer.click();
		return new EditCustomerForm();
	}
	@Step("Verify the NewAccount Link")
	public NewAccount createNewAccount() throws InterruptedException
	{
		EditCustomer.click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		newAccount.click();
		return new NewAccount();
	}
	@Step("Verify the MiniStatement Link")
	public MiniStatement takeMiniStatement() throws InterruptedException
	{
		EditCustomer.click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		miniStatement.click();
		return new MiniStatement();
	}
	@Step("Verify the DeleteAccount Link")
	public DeleteAccount deleteAccount() throws InterruptedException
	{
		EditCustomer.click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		deleteAcc.click();
		return new DeleteAccount();
	}
	@Step("Verify the Customized Statement Link")
	public CustomizedStatementpage CustomizedStatement() throws InterruptedException
	{
		EditCustomer.click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		CustStatement.click();
		return new CustomizedStatementpage();
	}
	
	public AmountDepositForm deposit()
	{
	   Deposit.click();
	   return new AmountDepositForm();
	}
	
	public fundTransferPage fundtransfer() throws InterruptedException
	{
		EditCustomer.click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		fundtransfer.click();
		return new fundTransferPage();
	}
	
	public BalanceEnquiryform clickBalEnquiry() throws InterruptedException
	{
		EditCustomer.click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		balenq.click();
		return new BalanceEnquiryform();
	}
	
	public EditAccForm clickEditAccount()
	{
		editAcc.click();
		return new EditAccForm();
	}
	
	


	

}
