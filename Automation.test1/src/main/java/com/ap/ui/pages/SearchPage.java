package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

public class SearchPage extends TestBase 
{
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(css="[class='page_heading product-listing")
	WebElement searchHeading;

	@FindBy(id="add_to_cart")
	WebElement addToCart;

	@FindBy(css="[title= 'Proceed to checkout']")
	WebElement checkOut;		
		
	public SearchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ProductDetailsPage SelectProduct(String productName)
	{
		String locator = "[class='product-name'][title='" + productName + "']";
		driver.findElement(By.cssSelector(locator)).click();
		return new ProductDetailsPage();
	}
	
	public String getHeader()
	{
		return searchHeading.getText();
	}
	
	
}
