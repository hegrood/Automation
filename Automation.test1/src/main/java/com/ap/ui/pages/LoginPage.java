package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class LoginPage extends TestBase 
{
	// Page Factory
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitButton;
	
	@FindBy(css="[class='logo img-responsive']")
	WebElement apLogo;
	
	@FindBy(id="email_create")
	WebElement emailSignup;
	
	@FindBy(id="SubmitCreate")
	WebElement signupSubmit;
	
	@FindBy(id="login_form")
	WebElement forgotPassword;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateAPImage()
	{
		return apLogo.isDisplayed();
	}
	
	public HomePage login (String uname, String passw)
	{
		username.sendKeys(uname);
		password.sendKeys(passw);
		submitButton.click();
		
		return new HomePage();
	}
}