package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

//import junit.framework.Assert;

public class OrderSummaryPage extends TestBase
{
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")
	WebElement checkoutButton;
	/*
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[3]/span")
	WebElement inStockButton;
	
	@FindBy(name="quantity_1_1_0_158570")
	WebElement quantityBox;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a/i")
	WebElement trashButton;*/
	/*
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/form/div/div[2]/div[1]/ul/li[7]/a")
	WebElement updateDelAddress;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/form/div/div[2]/div[2]/ul/li[7]/a")
	WebElement updateBillAddress;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/form/div/p/a")
	WebElement addNewAddress;*/
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/form/p/button")
	WebElement processAddress;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/p/button")
	WebElement processCarrier;
	
	@FindBy(id="cgv")
	WebElement agreeToTerms;
	
	/*@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/div/p[2]/a")
	WebElement tOSLink;*/
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")
	WebElement payByWire;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/form/p/button")
	WebElement confirmOrder;
	
	//@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/p/strong")
	@FindBy(css="[class='cheque-indent'][class='dark']") //.cheque-indent > strong:nth-child(1)
	WebElement orderConfirm;
	
	public OrderSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage ClickProceed() //same as proceedCheck/Out
	{
		checkoutButton.click();
		return this;
	}
	
	public OrderSummaryPage ProcessAddress() //same as proceedAddressCheckOut
	{
		processAddress.click();
		return this;
	}
	
	public OrderSummaryPage ProcessCarrier() //same as proceedShipping
	{
		agreeToTerms.click();
		processCarrier.click();
		return this;
	}
	
	public OrderSummaryPage PayByWire()
	{
		payByWire.click();
		confirmOrder.click();
		return this;
	}
	
	/*public OrderSummaryPage getOrderConfirm()
	{
		Assert.assertEquals(orderConfirm.getText(), "");
		return this;
	}*/
	
	public String GetOrderConfirm()
	{
		return orderConfirm.getText();
	}
	
	
}
