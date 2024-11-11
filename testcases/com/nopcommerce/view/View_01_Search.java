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
		homePage = PageGeneratorManager.getHomePageObject(driver);
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
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		homePage.openHomeFooterPage("customer-service", "search");
		customerSearchPage = PageGeneratorManager.getCustomerSearchPageObject(driver);
		Assert.assertEquals(customerSearchPage.getPageTitle("search-page"), "search");
		
		customerSearchPage.inputSearchForm("");
		Assert.assertEquals(customerSearchPage.getWarningText(), "search.searchtermminimumlengthisncharacters");
	}

	@Test
	public void Search_02_Data_Not_Exist() {
		customerSearchPage.inputSearchForm("Macbook Pro 2050");
		Assert.assertEquals(customerSearchPage.getResultText(), "catalog.products.noresult");
	}

	@Test
	public void Search_03_Product_Name_Relatively() {
		customerSearchPage.inputSearchForm("lenovo");
		Assert.assertTrue(customerSearchPage.verifyResultSearch());
	}

	@Test
	public void Search_04_Product_Name_Absolutely() {

	}

	@Test
	public void Advanced_Search_05_Parent_Categories() {

	}

	@Test
	public void Advanced_Search_06_Sub_Categories() {

	}

	@Test
	public void Advanced_Search_07_Incorrect_Manufacurer() {

	}

	@Test
	public void Advanced_Search_07_Correct_Manufacurer() {

	}

	@AfterClass
	public void afterClass() {

	}

}
