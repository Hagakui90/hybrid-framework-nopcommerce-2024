package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.Customer;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminCatalogProductsPageObject;
import pageObjects.admin.AdminCustomerCreatePageObject;
import pageObjects.admin.AdminCustomersCustomersPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminEditProductDetailsPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class Admin_02_Manage_Customer extends BaseTest {
	private WebDriver driver;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminCatalogProductsPageObject adminCatalogProductsPage;
	private AdminEditProductDetailsPageObject adminEditProductDetailsPage;
	private AdminCustomersCustomersPageObject adminCustomersCustomersPage;
	private AdminCustomerCreatePageObject adminCustomerCreatePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.enterToLoginForm(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
	}

	@Test
	public void Manage_Customer_01_Add_New() {
		adminDashboardPage.openAdminDashBoardSideBarPage("customers", "customers.customers");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.clickToAddNewButton();
		adminCustomerCreatePage = PageGeneratorManager.getAdminCustomerCreatePage(driver);
		Customer newCustomer = adminCustomerCreatePage.createCustomerInfo("ashleigh_gerla@gmail.com", "ashleigh_gerla", "Rosemary", "G Brooks",
				"Female", "The Wiz", "Guest", true, "Hipster-friendly web advocate. Wannabe tv maven. Devoted writer. Subtly charming travel fanatic.");
		adminCustomerCreatePage.inputToAddNewForm(newCustomer);
		adminCustomerCreatePage.sleepInSecond(3);
		adminCustomerCreatePage.clickToSaveButton("save-continue");
		Assert.assertEquals(adminCustomerCreatePage.getAlertSuccessMessage(), " admin.customers.customers.added");
		
	}

	@Test
	public void Manage_Customer_02_Search_With_Email() {

	}

	@Test
	public void Manage_Customer_03_Search_With_First_Name_Last_Name() {

	}

	@Test
	public void Manage_Customer_04_Search_With_Customer_Company() {

	}

	@Test
	public void Manage_Customer_05_Search_With_Customer_Full_Data() {

	}

	@Test
	public void Manage_Customer_06_Edit() {

	}

	@Test
	public void Manage_Customer_07_Add_New_Address() {

	}

	@Test
	public void Manage_Customer_08_Edit_Address() {

	}

	@Test
	public void Manage_Customer_09_Delete_Address() {

	}

	@AfterClass
	public void afterClass() {

	}

}
