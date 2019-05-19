package com.ap.ui.testcases;

import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

import junit.framework.Assert;

public class LoginTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	//calls TestBase constructor
	public LoginTest()
	{
		super();
	}
	
	//navigates to the login page
	@BeforeMethod
	public void setupDriver()
	{
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	//verifies if the page title exists
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		//homePage.clickOnSignIn();
		String title = loginPage.verifyPageTitle();
		Assert.assertEquals(title, "Login - My Store"); //available in testNG, capture a value and validates if it's true or not
	}
	
	//verifies if the logo loads
	@Test(priority=2)
	public void apLogoTest()
	{
		boolean value = loginPage.validateAPImage();
		Assert.assertTrue(value);
	}
	
	//verifies if a successful login is executed
	@Test(priority=3)
	public void loginTest()
	{
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
	}
	
	//closes the browser
	@AfterMethod
	public void closeBowser()
	{
		//makes the driver resign so you can get into the driver's seat yourself
		driver.quit();
	}
}
