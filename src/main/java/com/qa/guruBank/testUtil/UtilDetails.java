package com.qa.guruBank.testUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.guruBank.Base.TestBase;

public class UtilDetails extends TestBase  {
	
	public static long PAGE_LOAD_TIME=30;
	public static long IMPLICITE_TIME=40;
	

	static Workbook book;
	static Sheet sheet;
	public static String Xlfilepath="C:\\Users\\sys\\eclipse-workspace\\GuruBankV1\\src\\main\\java\\com\\qa\\guruBank\\TestData\\FreeCRMData.xlsx";


	public static Object[][] getTestdata(String SheetName)
	{
		FileInputStream file=null;
		
			
				try {
					file=new FileInputStream(Xlfilepath);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
			
				try {
					book=WorkbookFactory.create(file);
				} catch (EncryptedDocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		

		 sheet=book.getSheet(SheetName);
		 Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 
		 System.out.println(sheet.getLastRowNum());
		 System.out.println(sheet.getRow(0).getLastCellNum());
		 
				 
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
		return data;
				
		 
	}


	public static void alertMethod()
	{
		Alert alert=driver.switchTo().alert();
		String alrtMsg=driver.switchTo().alert().getText();
		System.out.println(alrtMsg);
		alert.accept();
		
	}
	
	public static void CaptureScreen(WebDriver driver,String Tname)
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/ScreenShots/"+Tname+".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("ScreenShotTaken");
	
	
	
      }
}	
