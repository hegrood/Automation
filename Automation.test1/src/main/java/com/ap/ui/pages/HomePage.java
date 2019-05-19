package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ap.ui.base.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(id="contact-link")
	WebElement contactLink;
	
	/*@FindBy(xpath="/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a")*/
	//@FindBy(css="[class='header_user_info']")
	@FindBy(css="[class='login']")
	WebElement signInLink;
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	@FindBy(css="[class='logout']")
	WebElement logoutLink;

	public void clickOnContactLink()
	{
		contactLink.click();
	}

	public void clickOnSignIn() 
	{
		signInLink.click();
	}
	
	public void clickOnLogout() 
	{
		logoutLink.click();
	}
	
	public SearchPage searchBox(String keys) 
	{
		searchBox.sendKeys(keys);
		searchButton.click();
		return new SearchPage();
	}
	
	public ProductDetailsPage selectProduct(String productName)
	{
		String locator = "[class='product-name'][title='"+ productName + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetailsPage();
	}
	/*public static void clickSearch() 
	{
		searchButton.click();
	}*/
}
