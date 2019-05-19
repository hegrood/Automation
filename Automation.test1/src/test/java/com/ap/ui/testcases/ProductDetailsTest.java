package com.ap.ui.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.dataprovider.DataProvider;
import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.ProductDetailsPage;

import junit.framework.Assert;

public class ProductDetailsTest extends TestBase
{
	ProductDetailsPage pDetailsPage;
	DataProvider dataProvider;
	HomePage homePage;
	
	
	public ProductDetailsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setupDriver()
	{
		initialization();
		pDetailsPage = new ProductDetailsPage();
	}
	
	/*@Test
	public void ProductDetailsPageTitleTest()
	{
		HomePage.selectProduct("Faded Short Sleeve T-shirts");
		String title = pDetailsPage.verifyPageTitle();
		Assert.assertEquals(title, "Login - My Store"); //available in testNG, capture a value and validates if it's true or not
	}*/
	
	/*
	@Test
	public void QuantityTest()
	{
		pDetailsPage.QuantityWanted(dataProvider.getQuantity());
	}
	*/
	

}
