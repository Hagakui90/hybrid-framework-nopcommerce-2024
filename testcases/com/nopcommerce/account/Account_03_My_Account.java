package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerAddressObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Account_03_My_Account extends BaseTest {
	private WebDriver driver;
	private String emailAddress = "automationfc.vn@gmail.com";
	private HomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private CustomerPageObject customerPage;
	private CustomerAddressObject customerAddressPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		userLoginPage = homePage.clickToLoginLink();

		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("123456");

		homePage = userLoginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), emailAddress);
	}

	@Test
	public void My_Account_01_Update_CustomerInfo() {
		customerPage.updateFullInfo("Female", "Automation", "FC", "afc3574@mail.vn", "Automation FC");

		
		Assert.assertEquals(customerPage.getUpdatedNotificationBarText(),"account.customerinfo.updated");
		Assert.assertTrue(customerPage.verifyCheckedGenderRadiobox("Female"));
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.firstname"), "Automation");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.lastname"), "FC");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), "afc3574@mail.vn");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.company"), "Automation FC");
	}

	public void My_Account_02_Add_Address() {
		customerPage.openDynamicSideBarPage("account.customeraddresses");
		customerAddressPage = PageGeneratorManager.getCustomerAddressObject(driver);
		customerAddressPage.openAddressForm();

		customerAddressPage.inputAddressForm(emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress, emailAddress);
	}

	@Test
	public void My_Account_03_Change_Password() {

	}

	@Test
	public void My_Account_04_Add_Review_Product() {

	}

	@AfterClass
	public void afterClass() {

	}

}
