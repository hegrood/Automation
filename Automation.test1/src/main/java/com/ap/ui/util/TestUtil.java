package com.ap.ui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ap.ui.base.TestBase;


public class TestUtil extends TestBase
{
	public static long Page_Load = 10;
	public static long Implicit_Wait = 10;
	
	//will allow for automated screenshot taking with dynamic file names using time stamps
	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException
	{
		//takes screenshot of the application
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//saves the screenshot to a file.
		//FileUtils.copyFile(srcfile, new File("user.dir" + "\\Screenshot_Test\\"+ System.currentTimeMillis()+".png"));
		
		//Alt
		String currentDirect = System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentDirect + "\\Screenshot_Test\\" + System.currentTimeMillis()+".png"));
		
	}
	
	//will allow you to interact/read with excel sheets
	public static String XL_SHEET_PATH =  "path of the excel sheet";
	
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	public static Object[][] getTestData(String sheetName)
	{
		//tells the script if there is no value for the file, do not run
		FileInputStream file = null;
		
		//exception handling so that we do not throw exceptions
		// will try to find if the file exists
		try
		{
			file = new FileInputStream(XL_SHEET_PATH);
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		//if the file is found, try to find the workbook
		try
		{
			book = WorkbookFactory.create(file);
		}
		// if the file exists but is in the wrong format
		catch (InvalidFormatException e)
		{
			e.printStackTrace();
		}
		// if the file exists but the workbook does not exist
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		//retrieve the data from the specified
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//loop through the sheet's rows
		for(int i = 0; i < sheet.getLastRowNum(); i++)
		{
			//loop through the row's cells
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++)
			{
				//get the data from the cell in the form of a string
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		//return the data that was found
		return data;
	}
	
	// method for error checking javascript
	// captures everything that is happening in/with the script.
	// also logs the response from the application instead of having to get it manually using devtoolsl
	public static void runTimeInfo(String messageType, String message) throws InterruptedException
	{	
		//creates a JavascriptExecutor object
		js = (JavascriptExecutor) driver;
		
		//tells the script to use jquery, using the script found on the given site, to get information on the elements
		js.executeScript("if (!window.JQuery){" + "var jquery = document.createElement('script'); jquery.type "
				+ "= 'text/javascript';" + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';" 
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);"+"}");
		Thread.sleep(2000);
		
		//use the script that is found at the specified link in order to translate the information
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
		
		// using header tags, get the information contained in the header such as the application response to each element being tested.
		js.executeScript("$('head').append('<link rel=\"stylesheet\" " 
		+ "href\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(3000);
		
		//tells us what information it fetch from the api (growl = fetch)
		js.executeScript("$ growl({ title: 'GET', message: '/'});");
		
		//error checking
		//if there's an error, execute this
		if (messageType.equals("error"))
		{
			js.executeScript("$growl.error({ title: 'ERROR' message: '"+message+"'});");
		}
		//if there's a message, execute this
		else if(messageType.equals("info"))
		{
			js.executeScript("$growl.warning({ title: 'Warning!!', message: 'your warning message will appear here'});");
		}
		
		else
			System.out.println("Show NO Error Message");
		Thread.sleep(3000);
	}	
}
