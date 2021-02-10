package com.qa.guruBank.testUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reports extends TestListenerAdapter {
	
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void OnStart(ITestContext testcontext)
	{
		//String timestamp=new SimpleDateFormat("yyyy.mm.dd:hh.mm.ss").format(new Date());
		//String repName="Test-Report-"+timestamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/guru.html"));
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("TesterName", "Surendra");
		extent.setSystemInfo("Browser", "Chrome");
		htmlReporter.config().setDocumentTitle("InetBankingProject");
		htmlReporter.config().setReportName("Functional TestAutomation Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void OnTestSuccess(ITestResult tr)
	{
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void OnTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String timestamp1=new SimpleDateFormat("yyyy.mm.dd:hh.mm.ss").format(new Date());
		
		String screenshotpath=System.getProperty("user.dir")+"/ScreenShots/"+tr.getName()+timestamp1+".png:";
		
		File f=new File(screenshotpath);
		if(f.exists())
		{
			try {
				logger.fail("ScreenShot is Below:"+logger.addScreenCaptureFromPath(screenshotpath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void OnTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void OnFinish(ITestContext context)
	{
		extent.flush();
	}
}
