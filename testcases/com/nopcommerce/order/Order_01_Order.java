package com.nopcommerce.order;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.BuildYourOwnComputerPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.DesktopsSubPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Order_01_Order extends BaseTest {
	private WebDriver driver;
	private String emailAddress = "afc3574@mail.vn";
	private HomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private CustomerPageObject customerPage;
	private DesktopsSubPageObject desktopsSubPage;
	private BuildYourOwnComputerPageObject buildYourOwnComputerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		userLoginPage = homePage.clickToLoginLink();

		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("Goodmorning11");

		homePage = userLoginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), emailAddress);
	}

	@Test
	public void Order_01_Add_To_Cart() {
		homePage.backToPage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToSubMenu("Computers", "Desktops");
		desktopsSubPage = PageGeneratorManager.getDesktopsSubPage(driver);

		desktopsSubPage.clickToAnyProduct("Build your own computer");
		buildYourOwnComputerPage = PageGeneratorManager.getBuildYourOwnComputerPage(driver);

		/*
		 * buildYourOwnComputerPage.clickToSubMenu("Books", ""); booksCategoryPage =
		 * PageGeneratorManager.getBooksCategoryPage(driver);
		 * booksCategoryPage.clickToAnyProduct("Where The River Takes Us: Sunday Times Children's Book of the Week");
		 */
		
		buildYourOwnComputerPage.buildOwnComputer();
		Assert.assertTrue(buildYourOwnComputerPage.getTextNotificationBar().equals("products.producthasbeenaddedtothecart.link"));
		Assert.assertTrue(buildYourOwnComputerPage.verifyShoppingCart());
		
		
	}

	@Test
	public void Order_02_Edit_Production_In_Shopping_Cart() {

	}

	@Test
	public void Order_03_Remove_From_Cart() {

	}

	@Test
	public void Order_04_Update_Shopping_Cart() {

	}

	@Test
	public void Order_05_Checkout() {

	}

	@AfterClass
	public void afterClass() {

	}

}
