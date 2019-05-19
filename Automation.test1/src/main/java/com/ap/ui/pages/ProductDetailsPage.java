package com.ap.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ap.ui.base.TestBase;

public class ProductDetailsPage extends TestBase 
{
@FindBy(id="quantity_wanted")
WebElement quantityBox;

@FindBy(name="group_1")
WebElement sizeDropdown;

@FindBy(name="Submit")
WebElement addToCart;

@FindBy(xpath="/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")
WebElement checkoutButton;

@FindBy(xpath="//*[@id='wishlist_button']")
WebElement addToWishlist;

@FindBy(css = "[class='fancybox-error']")
WebElement wishlistMessage;

@FindBy(css="[class='fancybox-item fancybox-xlose']")
WebElement wishlistCloseButton;


//constructor for initializing the elements
	public ProductDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//constructor for filling in the quantity text box
	public ProductDetailsPage QuantityWanted(String amount) //same as inputQuantity
	{
		quantityBox.clear();
		quantityBox.sendKeys(amount);
		return this;
	}
	
	public ProductDetailsPage SelectSize(String size)
	{
		Select select = new Select(sizeDropdown);
		select.selectByVisibleText(size);
		return this;
	}
	
	
	//method that adds the item to the cart/interacting with the add to cart button
	public ProductDetailsPage ClickAddToCart()
	{
		addToCart.click();
		return this;
	}

	//constructor for clicking the checkout button and creating an instance of Order Summary Page
	public OrderSummaryPage ClickCheckout() //same as proceedCheckOut
	{
		checkoutButton.click();
		return new OrderSummaryPage();
	}
	
	//method for clicking on the add to wishlist button
	public ProductDetailsPage AddToWishlist()
	{
		addToWishlist.click();
		return this;
	}
	
	//method for selecting a color based on the data that will be received later
	public ProductDetailsPage SelectProductColor(String color)
	{
		String locator = "[name='"+color+"']"; //this will come from excel file
		driver.findElement(By.cssSelector(locator)).click();
		return this;
	}
	
	//asserts if we received the proper message popup after adding the item to our wishlist then closes it
	public void VerifyWishlistMessage() //same as verifyAddwishListMSG()
	{
		/*String message = wishlistMessage.getText();
		return message;*/
		Assert.assertEquals(wishlistMessage.getText(), "Added to your wishlist.");
		wishlistCloseButton.click();
	}
}
