package com.nopcommerce.view;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.CustomerSearchPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;

public class View_01_Search extends BaseTest {
	private WebDriver driver;
	private String emailAddress = "afc3574@mail.vn";
	private HomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private CustomerPageObject customerPage;
	private CustomerSearchPageObject customerSearchPage;

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
	public void Search_01_Empty() {
		customerPage.backToPage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		homePage.openHomeFooterPage("customer-service", "search");
		customerSearchPage = PageGeneratorManager.getCustomerSearchPage(driver);
		Assert.assertEquals(customerSearchPage.getPageTitle("search-page"), "search");
		
		customerSearchPage.inputSearchForm("");
		Assert.assertEquals(customerSearchPage.getWarningText(), "search.searchtermminimumlengthisncharacters");
	}

	public void Search_02_Data_Not_Exist() {
		customerSearchPage.inputSearchForm("Macbook Pro 2050");
		Assert.assertEquals(customerSearchPage.getNoResultSearchText(), "catalog.products.noresult");
	}

	public void Search_03_Product_Name_Relatively() {
		customerSearchPage.inputSearchForm("lenovo");
		Assert.assertTrue(customerSearchPage.verifyResultSearchRelatively());
	}

	@Test
	public void Search_04_Product_Name_Absolutely() {
		customerSearchPage.inputSearchForm("Lenovo Thinkpad Carbon Laptop");
		Assert.assertTrue(customerSearchPage.verifyResultSearchAbsolutely("Lenovo Thinkpad Carbon Laptop"));
	}

	@Test
	public void Search_Advanced_Search_05_Parent_Categories() {
		customerSearchPage.inputAdvancedSearchForm("Apple MacBook Pro", "Computers", "", "common.all", "");
		Assert.assertEquals(customerSearchPage.getNoResultSearchText(), "catalog.products.noresult");
	}

	@Test
	public void Search_Advanced_Search_06_Sub_Categories() {
		customerSearchPage.inputAdvancedSearchForm("Apple MacBook Pro", "Computers", "subcategories", "common.all", "");
		Assert.assertTrue(customerSearchPage.verifyResultSearchAbsolutely("Apple MacBook Pro"));
	}

	@Test
	public void Search_Advanced_Search_07_Incorrect_Manufacurer() {
		customerSearchPage.inputAdvancedSearchForm("Apple MacBook Pro", "Computers", "subcategories", "HP", "");
		Assert.assertEquals(customerSearchPage.getNoResultSearchText(), "catalog.products.noresult");
	}

	@Test
	public void Search_Advanced_Search_08_Correct_Manufacurer() {
		customerSearchPage.inputAdvancedSearchForm("Apple MacBook Pro", "Computers", "subcategories", "Apple", "descriptions");
		Assert.assertTrue(customerSearchPage.verifyResultSearchAbsolutely("Apple MacBook Pro"));
	}

	@AfterClass
	public void afterClass() {

	}

}
