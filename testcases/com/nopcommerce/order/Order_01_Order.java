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
import pageObjects.user.CartPageObject;
import pageObjects.user.CheckoutPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.CustomerSearchPageObject;
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
	private CartPageObject cartPage;
	private CustomerSearchPageObject customerSearchPage;
	private CheckoutPageObject checkoutPage;

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

	
	public void Order_01_Add_To_Cart() {
		homePage.backToPage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToShoppingCart();
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.removeAllProductFromCart();
		cartPage.sleepInSecond(5);

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
	
	
	public void Order_02_Edit_Production_In_Shopping_Cart() {
		buildYourOwnComputerPage.clickToViewCartButton();
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.clickToEditButton();
		buildYourOwnComputerPage = PageGeneratorManager.getBuildYourOwnComputerPage(driver);
		Assert.assertTrue(buildYourOwnComputerPage.editProductInShoppingCart());
		Assert.assertTrue(buildYourOwnComputerPage.getTextNotificationBar().equals("products.producthasbeenaddedtothecart.link"));
		Assert.assertTrue(buildYourOwnComputerPage.verifyUpdatedShoppingCart());
	}

	
	public void Order_03_Remove_From_Cart() {
		buildYourOwnComputerPage.clickToViewCartButton();
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.removeAllProductFromCart();
		Assert.assertTrue(cartPage.getCartStatusText().contains("shoppingcart.cartisempty"));
	}
	
	public void Order_04_Update_Shopping_Cart() {
		cartPage.searchProduct("Lenovo IdeaCentre");
		customerSearchPage = PageGeneratorManager.getCustomerSearchPage(driver);
		customerSearchPage.updateProductToShoppingCart("Lenovo IdeaCentre");

		customerSearchPage.clickToShoppingCart();
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.updateQuantity("Lenovo IdeaCentre", "5");
		Assert.assertTrue(cartPage.getTotalPriceByProductName("Lenovo IdeaCentre").equals("$2,500.00"));
	}
	@Test
	public void Order_05_Checkout() {
		homePage.backToPage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToShoppingCart();
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.removeAllProductFromCart();
		cartPage.searchProduct("Apple iCam");
		customerSearchPage = PageGeneratorManager.getCustomerSearchPage(driver);
		customerSearchPage.updateProductToShoppingCart("Apple iCam");
		customerSearchPage.clickToShoppingCart();
		cartPage = PageGeneratorManager.getCartPage(driver);
		cartPage.updateQuantity("Apple iCam", "2");
		Assert.assertTrue(cartPage.getTotalPriceByProductName("Apple iCam").equals("$2,600.00"));

		cartPage.selectGiftWrapping("shoppingcart.checkoutattributes.priceadjustment");
		Assert.assertTrue(cartPage.getGiftWrappingLabel().contains("Yes"));
		Assert.assertTrue(cartPage.getItemTotalText("subtotal").equals("$2,610.00"));

		cartPage.inputToEstimateShippingPopup("Vietnam", "Hải Phòng", "10021", "checkout.pickuppoints");
		Assert.assertTrue(cartPage.getItemTotalText("totals.shipping").contains("$1.99"));
		
		cartPage.checkToTermOfService();
		checkoutPage = PageGeneratorManager.getCheckoutPage(driver);
		checkoutPage.clickToAddressDropdownByType("billing-address-select", "checkout.newaddress");
		
		checkoutPage.inputBillingNewAddressForm("Hasta", "Manana", "gogoloves021@gmail.com", "Vietnam", "Hà Nội", "Hà Nội", "123 Hoàn Kiếm, Hưng Đạo", "550000", "03843737");
		
		checkoutPage.inputShippingNewAddressForm("Hasta", "Manana", "gogoloves021@gmail.com", "Vietnam", "Hà Nội", "Hà Nội", "123 Hoàn Kiếm, Hưng Đạo", "550000", "03843737");
	}

	@AfterClass
	public void afterClass() {

	}

}
