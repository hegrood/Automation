package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver; //
	public static WebEventListener eventListener; //captures the event and sends to ExtentReporter

	public TestBase()
	{
		try 
		{	
			//created a new properties object
			propt = new Properties();
			//user.dir tells file input stream that the file lives within the project directory. Then it tells here the file is.
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ap/ui/config/config.properties");
			/*FileInputStream ipa = new FileInputStream("C:/TestAutomation/workspace/Automation.test1/src/main/java/com/ap/ui/config/config.properties");*/
			propt.load(ipa);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void initialization()
	{
		String browserName = propt.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/src/main/resources/drivers/chromedriver.exe"));
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\PS_QA\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\PS_QA\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\PS_QA\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("Opera"))
		{
			System.setProperty("webdriver.opera.driver", "C:\\PS_QA\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		
		//creates a new object of the browser
		//creates object for action that's occuring and sharing with driver. Speaker.
		en_driver = new EventFiringWebDriver(driver);
		//create object of WebEventListener to register it with EventFritingWebDriver. Microphone.
		eventListener = new WebEventListener();
		//event can be captured based on the method we will create in WebEventListener
		en_driver.register(eventListener);
		
		//we know the driver object is for browser, and that en_driver is for event that is taking place. 
		//we are declaring that they are equal to each when they are exchanging the info
		driver = en_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.timeouts().browserName.implicitelyWait(TestUtil);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.DAYS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.DAYS);
		
		
		driver.get(propt.getProperty("url"));
		
	}
}


