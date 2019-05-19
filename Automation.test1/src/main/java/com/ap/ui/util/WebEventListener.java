/*We have created this class WebDriverListener in order to implement the interface
to override all the methods and define certain helpful log actions which would
be displayed/logged as the app under test is being executed. These methods will be invoked
by itself automatically when certain actions are performed. Ex: click, findby, submit, screenshot, etc.)
*/
package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.ap.ui.base.TestBase;
import com.ap.ui.util.TestUtil;

public class WebEventListener extends TestBase implements WebDriverEventListener
{
	public void beforeNavigateTo(String url, WebDriver driver)
	{
		System.out.println("Before navi to: "+url+"'");
	}
	public void afterNavigateTo(String url, WebDriver driver)
	{
		System.out.println("Navigate to: "+url+"'");
	}
	/*public void beforeChangeValueOf(WebElement element, WebDriver driver)
	{
		System.out.println("Value of: "+element.toString()+" before any changes");
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver)
	{
		System.out.println("Element value changed to: "+element.toString());
	}*/
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend)
	{
		System.out.println("Value of: "+element.toString()+" before any changes");
	}
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend)
	{
		System.out.println("Element value changed to: "+element.toString());
	}
	public void beforeClickOn(WebElement element, WebDriver driver)
	{
		System.out.println("Clicking on : "+element.toString());
	}
	public void afterClickOn(WebElement element, WebDriver driver)
	{
		System.out.println("Successfully clicked on: "+element.toString());
 	}
	//
	public void beforeNavigateBack(WebDriver driver) 
	{
		System.out.println("Navigating back to previous page");
	}
	public void afterNavigateBack(WebDriver driver) 
	{
		System.out.println("Previous page loaded");
	}
	//
	public void beforeNavigateForward(WebDriver driver) 
	{
		System.out.println("Navigating to next page");
	}
	public void afterNavigateForward(WebDriver driver) 
	{
		System.out.println("Next page loaded");
	}
	public void onException(Throwable error, WebDriver driver) 
	{
		System.out.println("Exception occured: "+ error);
		try
		{
			TestUtil.takeScreenshotAtEndOfTest(driver);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void beforeFindBy(By by, WebElement element, WebDriver driver) 
	{
		System.out.println("Attempting to find the element: "+by.toString());
	}
	public void afterFindBy(By by, WebElement element, WebDriver driver) 
	{
		System.out.println("Element: "+by.toString()+" was succesfully found");
	}
	//these are non overridden methods of the WebListenerClass
	public void beforeNavigateRefresh(WebDriver driver)
	{
		
	}
	public void afterNavigateRefresh(WebDriver driver) 
	{
			
	}
	//these are non overridden methods of the WebListenerClass
	public void afterScript(String script, WebDriver driver) 
	{
		
	}
	public void beforeScript(String script, WebDriver driver) 	{
		
	}
	//these are non overridden methods of the WebListenerClass
	public void beforeAlertAccept(WebDriver driver)
	{
		
	}
	public void afterAlertAccept(WebDriver driver)
	{
		
	}
	//these are non overridden methods of the WebListenerClass
	public void beforeAlertDismiss(WebDriver driver) 
	{
		
	}
	public void afterAlertDismiss(WebDriver driver)
	{
		
	}
	/*public void afterNavigateBack(WebElement element, WebDriver arg0) 
	{
		// Empty block 
	}
	public void beforeNavigateBack(WebElement element, WebDriver arg0) 
	{
		// Empty block
	}*/
	//these are non overridden methods of the WebListenerClass
	public <x> void beforeGetScreenShotAs(OutputType<x> arg0)
	{
		
	}
	public <x> void afterGetScreenShotAs(OutputType<x> arg0, x arg1)
	{
		
	}
	//these are non overridden methods of the WebListenerClass
	public void beforeGetText(WebElement arg0, WebDriver arg1)
	{
		
	}
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2)
	{
		
	}
	//these are non overridden methods of the WebListenerClass
	public void beforeSwitchToWindows (String arg0, WebDriver arg1)
	{
		
	}
	public void afterSwitchToWindows (String arg0, WebDriver arg1)
	{
		
	}
	
}
