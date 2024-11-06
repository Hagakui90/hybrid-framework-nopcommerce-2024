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
	private String emailAddress = "afc3574@mail.vn";
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

	
	public void My_Account_01_Update_CustomerInfo() {
		customerPage.updateFullInfo("Female", "Automation", "FC", "afc3574@mail.vn", "Automation FC");

		
		Assert.assertEquals(customerPage.getUpdatedNotificationBarText(),"account.customerinfo.updated");
		Assert.assertTrue(customerPage.verifyCheckedGenderRadiobox("Female"));
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.firstname"), "Automation");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.lastname"), "FC");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), "afc3574@mail.vn");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.company"), "Automation FC");
	}
	@Test
	public void My_Account_02_Add_Address() {
		customerPage.openDynamicSideBarPage("account.customeraddresses");
		customerAddressPage = PageGeneratorManager.getCustomerAddressObject(driver);
		
		customerAddressPage.openAddressForm();
		customerAddressPage.inputAddressForm("Automation", "FC", "vivo.vn@gmail.com", "Automation FC", "Vietnam", "Hải Phòng", "Hải Phòng", "123/04 Lê Lai", "234/05 Hải Phòng", "550000", "0123456789", "0987654321");
		customerAddressPage.sleepInSecond(10);
		Assert.assertEquals(customerAddressPage.getAddedInfoText("name"),"Automation FC");
		Assert.assertTrue(customerAddressPage.getAddedInfoText("email").contains("vivo.vn@gmail.com"));
		Assert.assertTrue(customerAddressPage.getAddedInfoText("phone").contains("0123456789"));
		Assert.assertTrue(customerAddressPage.getAddedInfoText("fax").contains("0987654321"));
		Assert.assertEquals(customerAddressPage.getAddedInfoText("company"),"Automation FC");
		Assert.assertEquals(customerAddressPage.getAddedInfoText("country"),"Vietnam");
		Assert.assertEquals(customerAddressPage.getAddedInfoText("address1"),"123/04 Lê Lai");
		Assert.assertEquals(customerAddressPage.getAddedInfoText("address2"),"234/05 Hải Phòng");
		Assert.assertEquals(customerAddressPage.getAddedInfoText("zippostalcode"),"550000");
		Assert.assertEquals(customerAddressPage.getAddedNotificationBarText(),"account.customeraddresses.added");
		
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
