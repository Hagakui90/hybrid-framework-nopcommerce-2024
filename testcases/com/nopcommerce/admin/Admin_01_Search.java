package com.nopcommerce.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import commons.Product;
import pageObjects.admin.AdminCatalogProductsPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class Admin_01_Search extends BaseTest {

	private WebDriver driver;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminCatalogProductsPageObject adminCatalogProductsPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.enterToLoginForm(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
	}

	@Test
	public void Search_01_Product_Name() {
		adminDashboardPage.openAdminDashBoardSideBarPage("catalog", "products");
		adminCatalogProductsPage = PageGeneratorManager.getAdminCatalogProductPage(driver);
		adminCatalogProductsPage.searchByName("Lenovo Idea");
		List<Product> listSearchedProduct = adminCatalogProductsPage.getListProductSearchByName();
		Assert.assertTrue(listSearchedProduct.get(0).getTitleOfProduct().equals("Lenovo IdeaCentre"));
		Assert.assertTrue(listSearchedProduct.get(0).getSkuOfProduct().equals("LE_IC_600"));
		Assert.assertTrue(listSearchedProduct.get(0).getPriceOfProduct().equals("500"));
		Assert.assertTrue(listSearchedProduct.get(0).getStockQuantity().equals("10000"));
		System.out.println(listSearchedProduct.get(0).getStatusOfPublished());
		Assert.assertTrue(listSearchedProduct.get(0).getStatusOfPublished());
	}

	@Test
	public void Search_02_Product_Name_Parent_Category_Unchecked() {
		adminCatalogProductsPage.searchByNameAndCategory("Lenovo IdeaCentre", "Computers");
		Assert.assertEquals(adminCatalogProductsPage.getEmptyTableText(), "admin.dt.emptytable");
	}

	@Test
	public void Search_03_Product_Name_Parent_Category_UChecked() {

	}

	@Test
	public void Search_04_Product_Name_Child_Category() {

	}

	@Test
	public void Search_05_Product_Name_Manufacturer() {

	}

	@Test
	public void Search_06_Product_SKU() {

	}

	@AfterClass
	public void afterClass() {

	}

}
