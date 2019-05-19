package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;

public class ContactTest extends TestBase
{
	ContactsPage contactsPage;
	HomePage homePage;
	
	
	public ContactTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUpDriver()
	{
		initialization();
		contactsPage = new ContactsPage();
		homePage = new HomePage();
	}
	
	@Test(priority=1)
	public void testContact()
	{
		homePage.clickOnContactLink();
		contactsPage = contactsPage.fillContactForm("Customer Service", "Random@test.com", "Testing ", "This is for test purpose");
		contactsPage.submitMessage();
		String successMessage = contactsPage.getMessage();
		Assert.assertEquals(successMessage, "Your message has been successfully sent to our team");
	}
	
	@AfterMethod
	public void closeBowser()
	{
		driver.quit();
	}
}
