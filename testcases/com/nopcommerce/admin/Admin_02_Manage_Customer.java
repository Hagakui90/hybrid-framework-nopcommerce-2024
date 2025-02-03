package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.Address;
import commons.BaseTest;
import commons.Customer;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminAddNewAddressesPageObject;
import pageObjects.admin.AdminCustomerCreatePageObject;
import pageObjects.admin.AdminCustomersCustomersPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminEditAddressPageObject;
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
	private AdminAddNewAddressesPageObject adminAddNewAddressesPage;
	private AdminEditAddressPageObject adminEditAddressPage;
	private Customer newCustomer;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("----------Open website-----------");
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.enterToLoginForm(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
	}

	
	public void Manage_Customer_01_Add_New() {
		adminDashboardPage.openAdminDashBoardSideBarPage("customers", "customers.customers");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.clickToAddNewButton();
		adminCustomerCreatePage = PageGeneratorManager.getAdminCustomerCreatePage(driver);
		newCustomer = adminCustomerCreatePage.createCustomerInfo("lexie.shiel@gmail.com", "ihie5Cie", "J Davis", "Dorothy ", "Female", "Wheels Discount Auto", "Guests", true,
				"Creator. Extreme coffee specialist. Subtly charming twitter nerd. Certified analyst. Devoted alcohol guru. Avid gamer.");
		adminCustomerCreatePage.inputToAddNewForm(newCustomer);
		adminCustomerCreatePage.clickToSaveButton("save-continue");
		adminEditCustomerDetailsPage = PageGeneratorManager.getAdminEditCustomerDetailsPage(driver);
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

		adminEditCustomerDetailsPage.clickToBackToList();
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.searchListCustomerRoles("Guests");
		adminCustomersCustomersPage.sleepInSecond(3);
		Assert.assertTrue(adminCustomersCustomersPage.verifyCustomerByRole(newCustomer));

	}

	public void Manage_Customer_02_Search_With_Email() {
		adminDashboardPage.openAdminDashBoardSideBarPage("customers", "customers.customers");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);

		adminCustomersCustomersPage.inputInfoTextbox("SearchEmail", "murphy_powlows@hotmail.com");
		adminCustomersCustomersPage.searchListCustomerRoles("Guests");
		adminCustomersCustomersPage.sleepInSecond(3);

		Assert.assertTrue(adminCustomersCustomersPage.verifyCustomerByEmailAndRole("murphy_powlows@hotmail.com", "Guests"));
		adminCustomersCustomersPage.backToPage(driver);
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.sleepInSecond(2);
	}

	public void Manage_Customer_03_Search_With_First_Name_Last_Name() {
		adminDashboardPage.openAdminDashBoardSideBarPage("customers", "customers.customers");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.inputInfoTextbox("SearchFirstName", "Misty");
		adminCustomersCustomersPage.inputInfoTextbox("SearchLastName", "E Brooks");
		adminCustomersCustomersPage.searchListCustomerRoles("Guests");
		adminCustomersCustomersPage.sleepInSecond(3);

		Assert.assertTrue(adminCustomersCustomersPage.verifyCustomerByFullNameAndRole("Misty", "E Brooks", "Guests"));
		adminCustomersCustomersPage.backToPage(driver);
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.sleepInSecond(2);
	}

	
	public void Manage_Customer_04_Search_With_Customer_Company() {
		adminDashboardPage.openAdminDashBoardSideBarPage("customers", "customers.customers");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);

		adminCustomersCustomersPage.inputInfoTextbox("SearchCompany", "Security Sporting Goods");
		adminCustomersCustomersPage.searchListCustomerRoles("Guests");
		adminCustomersCustomersPage.sleepInSecond(3);

		Assert.assertTrue(adminCustomersCustomersPage.verifyCustomerByCompanyAndRole("Security Sporting Goods", "Guests"));
		adminCustomersCustomersPage.backToPage(driver);
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.sleepInSecond(2);

	}

	public void Manage_Customer_05_Search_With_Customer_Full_Data() {
		adminDashboardPage.openAdminDashBoardSideBarPage("customers", "customers.customers");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		
		adminCustomersCustomersPage.inputInfoTextbox("SearchEmail", "murphy_powlows@hotmail.com");
		adminCustomersCustomersPage.inputInfoTextbox("SearchFirstName", "Misty");
		adminCustomersCustomersPage.inputInfoTextbox("SearchLastName", "E Brooks");
		adminCustomersCustomersPage.inputInfoTextbox("SearchCompany", "Security Sporting Goods");
		adminCustomersCustomersPage.searchListCustomerRoles("Guests");
		adminCustomersCustomersPage.isPageLoadedSuccess(driver);
		
		Assert.assertTrue(adminCustomersCustomersPage.verifyCustomerByEmailAndRole("murphy_powlows@hotmail.com", "Guests"));
		adminCustomersCustomersPage.backToPage(driver);
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.sleepInSecond(2);
		Assert.assertTrue(adminCustomersCustomersPage.verifyCustomerByFullNameAndRole("Misty", "E Brooks", "Guests"));
		adminCustomersCustomersPage.backToPage(driver);
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.sleepInSecond(2);
		adminCustomersCustomersPage.inputInfoTextbox("SearchCompany", "Security Sporting Goods");
		adminCustomersCustomersPage.backToPage(driver);
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		adminCustomersCustomersPage.sleepInSecond(2);
	}

	@Test
	public void Manage_Customer_06_Edit() {
		log.info("Manage_Customer_06 - Edit customer: Step 1: Open Customer sidebar");
		adminDashboardPage.openAdminDashBoardSideBarPage("customers", "customers.customers");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		
		log.info("Manage_Customer_06 - Edit customer: Step 2: Input Customer information to search");
		adminCustomersCustomersPage.inputInfoTextbox("SearchEmail", "lexie.shiel@gmail.com");
		adminCustomersCustomersPage.inputInfoTextbox("SearchFirstName", "J Davis");
		adminCustomersCustomersPage.inputInfoTextbox("SearchLastName", "Dorothy");
		adminCustomersCustomersPage.inputInfoTextbox("SearchCompany", "Wheels Discount Auto");
		adminCustomersCustomersPage.searchListCustomerRoles("Guests");
		adminCustomersCustomersPage.isPageLoadedSuccess(driver);
		
		log.info("Manage_Customer_06 - Edit customer: Step 3: Select Edit button");
		adminCustomersCustomersPage.selectEditCustomerButton();
		AdminEditCustomerDetailsPageObject adminEditCustomerDetailsPage = PageGeneratorManager.getAdminEditCustomerDetailsPage(driver);
		adminEditCustomerDetailsPage.editCustomer("edited_murphy_powlows@hotmail.com", "edited_Misty", "edited_E Brooks", "edited_Security Sporting Goods", "Edit Customer (Guests)");
		
		log.info("Manage_Customer_06 - Edit customer: Step 4: Verify edit successfully.");
		adminCustomersCustomersPage = PageGeneratorManager.getAdminCustomersCustomerPage(driver);
		verifyTrue(adminCustomersCustomersPage.getAlertSuccessMessage().contains("updated."));
		
		adminCustomersCustomersPage.inputInfoTextbox("SearchEmail", "edited_murphy_powlows@hotmail.com");
		adminCustomersCustomersPage.inputInfoTextbox("SearchFirstName", "edited_Misty");
		adminCustomersCustomersPage.inputInfoTextbox("SearchLastName", "edited_E Brooks");
		adminCustomersCustomersPage.inputInfoTextbox("SearchCompany", "edited_Security Sporting Goods");
		adminCustomersCustomersPage.searchListCustomerRoles("Guests");
		adminCustomersCustomersPage.isPageLoadedSuccess(driver);
		
		log.info("Manage_Customer_06 - Edit customer: Step 5: Find edited customer and verify edited customer");
		verifyFalse(adminCustomersCustomersPage.verifyCustomerByCompanyAndRole("edited_Security Sporting Goods", "Guests"));
		adminCustomersCustomersPage.sleepInSecond(2);
	}

	@Test
	public void Manage_Customer_07_Add_New_Address() {
		log.info("Manage_Customer_07 - Add_New_Address: Step 1: Select Edit button");
		adminCustomersCustomersPage.selectEditCustomerButton();
		adminEditCustomerDetailsPage = PageGeneratorManager.getAdminEditCustomerDetailsPage(driver);
		
		log.info("Manage_Customer_07 - Add_New_Address: Step 2: Click to Add new Address");
		adminAddNewAddressesPage = adminEditCustomerDetailsPage.clickToAddNewAddress();
		
		adminAddNewAddressesPage.isPageLoadedSuccess(driver);
		
		Address address = new Address("Nash", "Oberbrunner", "murphy_powlows@hotmail.com", "", "United States of America", "South Carolina", "", "Spartanburg", "2161 E Main St",
				"", "29307", "(864) 579-9845", "3534545");
		log.info("Manage_Customer_07 - Add_New_Address: Step 3: Input new Address");
		adminAddNewAddressesPage.inputFormAddNewAddress(address);
		
		log.info("Manage_Customer_07 - Add_New_Address: Step 4: Verify added successfully");
		verifyTrue(adminAddNewAddressesPage.getAlertSuccessMessage().contains("added"));
		
		log.info("Manage_Customer_07 - Add_New_Address: Step 5: New Address added");
		verifyTrue(adminAddNewAddressesPage.verifyAddedNewAddress(address));
		
		log.info("Manage_Customer_07 - Add_New_Address: Step 6: Back To Customer List and verify added address");
		adminEditCustomerDetailsPage = adminAddNewAddressesPage.backToCustomerList();
		verifyTrue(adminEditCustomerDetailsPage.verifyAddedNewAddressInList(address));
		
	}

	@Test
	public void Manage_Customer_08_Edit_Address() {
		adminEditCustomerDetailsPage.clickToEditOrDeleteButtonAtAnyCard("addresses", "edit");
		adminEditAddressPage = PageGeneratorManager.getAdminEditAddressPage(driver);
		Address newAddress = new Address("J Davis", "Dorothy", "lexie.shiel@gmail.com", "Wheels Discount Auto", "United States of America", "New Jersey", 
				"Mercer County", "Mercerville", "4797 Moonlight Drive", "", "08619", "609-229-5630", "");
		adminEditAddressPage.inputFormEditAddress(newAddress);
		
		verifyTrue(adminEditAddressPage.getAlertSuccessMessage().contains("updated"));
		verifyTrue(adminEditAddressPage.verifyEditedAddress(newAddress));
		adminEditAddressPage.backToCustomerList();
		adminEditCustomerDetailsPage = PageGeneratorManager.getAdminEditCustomerDetailsPage(driver);
		verifyTrue(adminEditCustomerDetailsPage.verifyAddedNewAddressInList(newAddress));
	}

	@Test
	public void Manage_Customer_09_Delete_Address() {
		adminEditCustomerDetailsPage.clickToEditOrDeleteButtonAtAnyCard("addresses", "delete");
		adminEditCustomerDetailsPage.acceptToAlert(driver);
		verifyTrue(adminEditCustomerDetailsPage.isTableEmptyByCardName("addresses"));
	}

	@AfterClass
	public void afterClass() {

	}

}
