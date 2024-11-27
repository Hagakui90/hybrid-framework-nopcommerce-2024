package com.nopcommerce.view;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import commons.Product;
import pageObjects.user.CartPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.DetailProductPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.WishlistPageObject;

public class View_03_Wishlist_Compare_Recent_View extends BaseTest{
	private WebDriver driver;
	private String emailAddress = "afc3574@mail.vn";
	private HomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private CustomerPageObject customerPage;
	private DetailProductPageObject detailProductPage;
	private WishlistPageObject wishlistPage;
	private String nameProduct;
	private String priceProduct;
	private CartPageObject cartPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		userLoginPage = homePage.clickToLoginLink();

		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("Goodmorning11");

		homePage = userLoginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), emailAddress);
	}

	
	public void Wishlist_01_Add_Wishlist() {
		customerPage.backToPage(driver);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		detailProductPage = homePage.clickToProduct("Where The River Takes Us: Sunday Times Children's Book of the Week");
		String titleSelectedProduct = detailProductPage.getTitleDetailProduct();
		Assert.assertTrue(detailProductPage.getPageTitle(driver).contains("Where The River Takes Us: Sunday Times Children's Book of the Week"));
		Assert.assertTrue(titleSelectedProduct.contains("Where The River Takes Us: Sunday Times Children's Book of the Week"));
		
		detailProductPage.clickToAddToWishlist();
		
		nameProduct = detailProductPage.getTitleDetailProduct();
		priceProduct = detailProductPage.getPriceProduct();
		Assert.assertTrue(detailProductPage.getTextNotificationBar().contains("products.producthasbeenaddedtothewishlist.link"));
		
		detailProductPage.openHomeFooterPage("my-account", "wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		System.out.println("Price Product: " + priceProduct);
		Assert.assertTrue(wishlistPage.verifyAddedProductInWishlist(nameProduct, priceProduct));
		
		wishlistPage.clickToSharingLink();
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		Assert.assertTrue(wishlistPage.getTitleLinkSharing().equals("wishlist.wishlistof"));
		
	}

	
	public void Wishlist_02_Add_Product_From_Cart_To_Wishlist() {
		wishlistPage.addToCart(nameProduct);
		cartPage = PageGeneratorManager.getCartPageObject(driver);
		Assert.assertTrue(cartPage.verifyAddedProductInCart(nameProduct, priceProduct));
		
		cartPage.backToPage(driver);
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		Assert.assertFalse(wishlistPage.verifyAddedProductInWishlist(nameProduct, priceProduct));
	}

	
	public void Wishlist_03_Remove_Product() {
		wishlistPage.clickToLogoLink();
		homePage = PageGeneratorManager.getHomePageObject(driver);
		detailProductPage = homePage.clickToProduct("Where The River Takes Us: Sunday Times Children's Book of the Week");
		detailProductPage.clickToAddToWishlist();
		
		detailProductPage.clickToWishlistHeaderLinkText();
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		wishlistPage.clickToRemoveProduct("Where The River Takes Us: Sunday Times Children's Book of the Week");
		Assert.assertTrue(wishlistPage.verifyRemovedProductInWishlist("Where The River Takes Us: Sunday Times Children's Book of the Week"));
		
		
	}

	@Test
	public void Compare_04_Add_Product() {
		customerPage.clickToLogoLink();
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		Product product_1 = homePage.addProductToCompare("Lessons in Chemistry A Novel");
		Assert.assertTrue(homePage.getTextNotificationBar().equals("products.producthasbeenaddedtocomparelist.link"));
		
		Product product_2 = homePage.addProductToCompare("Stig of the Dump");
		Assert.assertTrue(homePage.getTextNotificationBar().equals("products.producthasbeenaddedtocomparelist.link"));
		
		homePage.openHomeFooterPage("customer-service", "products.compare.list");
	}

	
	public void Recently_View_05_View_Product() {

	}

	@AfterClass
	public void afterClass() {

	}

}
