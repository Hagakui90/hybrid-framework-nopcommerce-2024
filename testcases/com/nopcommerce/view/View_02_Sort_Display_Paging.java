package com.nopcommerce.view;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminCatalogProductsPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.guest.BooksSubPageObject;
import pageObjects.guest.ComputersCategoryPageObject;
import pageObjects.guest.NotebooksSubPageObject;
import pageObjects.user.HomePageObject;

public class View_02_Sort_Display_Paging extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersCategoryPageObject computersPage;
	private NotebooksSubPageObject notebooksSubPage;
	private BooksSubPageObject booksSubPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminLoginPageObject adminLoginPage;
	private String userUrl = GlobalConstants.DEV_USER_URL;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;
	private AdminCatalogProductsPageObject adminCatalogProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		homePage.openHomeHeaderMenuPage("Computers");
		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		Assert.assertEquals(computersPage.getPageTitle(), "Computers");

		computersPage.openCategoriesSideBarPage("Computers", "Notebooks");
		notebooksSubPage = PageGeneratorManager.getNotebooksSubPage(driver);
		Assert.assertEquals(notebooksSubPage.getPageTitle(), "Notebooks");
	}
	@Test
	public void Sort_01_Name_A_To_Z() {
		Assert.assertTrue(notebooksSubPage.verifySortNameAscending());
	}
	@Test
	public void Sort_02_Name_Z_To_A() {
		Assert.assertTrue(notebooksSubPage.verifySortNameDescending());
	}

	@Test
	public void Sort_03_Price_Low_To_High() {
		Assert.assertTrue(notebooksSubPage.verifySortPriceAscending());
	}

	@Test
	public void Sort_04_Price_High_To_Low() {
		Assert.assertTrue(notebooksSubPage.verifySortPriceDescending());
	}

	@Test
	public void Sort_05_Created_On() {
		notebooksSubPage.openPageUrl(driver, adminUrl);
		Assert.assertTrue(homePage.isPageLoadedSuccess(driver));
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.enterToLoginForm(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
		adminDashboardPage.openAdminDashBoardSideBarPage("admin.catalog", "admin.catalog.products");
		adminCatalogProductPage = PageGeneratorManager.getAdminCatalogProductPage(driver);
		adminCatalogProductPage.isPageLoadedSuccess(driver);
		adminCatalogProductPage.searchByCategory("Books");
		adminCatalogProductPage.isPageLoadedSuccess(driver);
	} 
	
	@Test
	public void Display_05_3_Products_Per_Page() {
		notebooksSubPage.openCategoriesSideBarPage("Books", "");
		booksSubPage = PageGeneratorManager.getBooksSubPageObject(driver);
		Assert.assertEquals(booksSubPage.getPageTitle(), "Books");
		booksSubPage.sleepInSecond(2);
		
		Assert.assertTrue(booksSubPage.verifyPaging("3"));
		Assert.assertTrue(booksSubPage.isPageActiveByNumber("Current page"));
		Assert.assertTrue(booksSubPage.isNextPageButtonActived("Current page"));
		booksSubPage.sleepInSecond(2);
		
		booksSubPage.clickToPageByNumber("2");
		Assert.assertTrue(booksSubPage.isPageActiveByNumber("2"));
		Assert.assertTrue(booksSubPage.isPreviousPageButtonActived("2"));
		booksSubPage.sleepInSecond(2);
	}

	@Test
	public void Display_06_6_Products_Per_Page() {
		booksSubPage.openCategoriesSideBarPage("Computers", "Notebooks");
		notebooksSubPage = PageGeneratorManager.getNotebooksSubPage(driver);
		Assert.assertEquals(notebooksSubPage.getPageTitle(), "Notebooks");
		Assert.assertTrue(notebooksSubPage.verifyPaging("6"));
		Assert.assertTrue(notebooksSubPage.isPagingActivated());
	}

	@Test
	public void Display_07_9_Products_Per_Page() {
		Assert.assertTrue(notebooksSubPage.verifyPaging("9"));
		Assert.assertTrue(notebooksSubPage.isPagingActivated());
	}

	@AfterClass
	public void afterClass() {

	}

}
