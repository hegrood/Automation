package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;
import com.ap.ui.pages.ProductDetailsPage;
import com.ap.ui.pages.SearchPage;

public class WishListTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	SearchPage searchPage;
	ProductDetailsPage productDetailsPage;
	

	public WishListTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUpDriver()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
	}
	
	@Test
	public void TestAddProductToWishList()
	{
		//sign in
		String product = "Printed Chiffon Dress ";
		homePage.clickOnSignIn();
		homePage = loginPage.login(propt.getProperty("username"), propt.getProperty("password"));
		//search product
		searchPage = homePage.searchBox(product);
		String header = searchPage.getHeader();
		//System.out.println(header);
		Assert.assertTrue(header.toLowerCase().contains(product.toLowerCase()));
		
		//add product to the wish list
		productDetailsPage.AddToWishlist();
		productDetailsPage.VerifyWishlistMessage();
		//log out
		homePage.clickOnLogout();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
