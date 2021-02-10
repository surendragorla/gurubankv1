package com.qa.guruBank.listeners;

import org.openqa.selenium.OutputType;




import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.guruBank.Base.TestBase;

import io.qameta.allure.Attachment;

public class TestNGListener implements ITestListener  {

	@Override
	public void onTestFailure(ITestResult result) {
		saveScreenShotOnFailure(TestBase.getDriver());
		saveLogs(result.getMethod().getConstructorOrMethod().getName());
	}
	
	@Attachment(value="ScreenShots",type="image/png")
	public byte[] saveScreenShotOnFailure(WebDriver driver)
	{
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value="Stacktrace",type="text/plain")
	public static String saveLogs(String message)
	{
		return message;
	}

}
