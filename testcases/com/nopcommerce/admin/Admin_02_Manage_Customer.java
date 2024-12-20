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
import pageObjects.admin.AdminCustomerCreatePageObject;
import pageObjects.admin.AdminCustomersCustomersPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminEditCustomerDetailsPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class Admin_02_Manage_Customer extends BaseTest {
	private WebDriver driver;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private AdminCustomersCustomersPageObject adminCustomersCustomersPage;
	private AdminCustomerCreatePageObject adminCustomerCreatePage;
	private AdminEditCustomerDetailsPageObject adminEditCustomerDetailsPage;
	
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
		Customer newCustomer = adminCustomerCreatePage.createCustomerInfo("julio19962008@hotmail.com", "ashleigh_gerla", "Rosemary", "G Brooks",
				"Female", "The Wiz", "Guest", true, "Hipster-friendly web advocate. Wannabe tv maven. Devoted writer. Subtly charming travel fanatic.");
		adminCustomerCreatePage.inputToAddNewForm(newCustomer);
		adminCustomerCreatePage.clickToSaveButton("save-continue");
		adminEditCustomerDetailsPage = PageGeneratorManager.getAdminCustomerDetailsPage(driver);
		adminEditCustomerDetailsPage.sleepInSecond(3);
		
		Assert.assertTrue(adminEditCustomerDetailsPage.getAlertSuccessMessage().contains("admin.customers.customers.added"));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyEmail(newCustomer.getEmail()));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyFirstName(newCustomer.getFirstName()));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyLastName(newCustomer.getLastName()));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyGender(newCustomer.getSex()));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyCompany(newCustomer.getCompany()));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyRole(newCustomer.getRole()));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyActive(newCustomer.isActive()));
		Assert.assertTrue(adminEditCustomerDetailsPage.verifyAdminComment(newCustomer.getAdminComment()));
		
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
