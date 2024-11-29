package com.nopcommerce.account;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;

public class Account_01_Register extends BaseTest {
	private WebDriver driver;
	private String emailAddress;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private CustomerPageObject customerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

	}

	@Test
	public void Register_01_Empty() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFirstNameErrorTextMessage(), "account.fields.firstname.required");
		Assert.assertEquals(registerPage.getLastNameErrorTextMessage(), "account.fields.lastname.required");
		Assert.assertEquals(registerPage.getEmailErrorTextMessage(), "account.fields.email.required");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorTextMessage(), "account.fields.confirmpassword.required");

	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Hana");
		registerPage.enterToLastNameTextbox("Hasta");
		registerPage.enterToEmailTextbox("21334@vn");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorTextMessage(), "common.wrongemail");

	}

	@Test
	public void Register_03_Successful() {
		homePage = registerPage.clickToNopCommerceLogo();

		
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Hana");
		registerPage.enterToLastNameTextbox("Hasta");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getCompletedRegisterTextMessage(), "account.register.result.standard");
		

		customerPage = registerPage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue(GlobalConstants.FIRST_NAME_INFO), "Hana");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue(GlobalConstants.LAST_NAME_INFO), "Hasta");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("Email"), emailAddress);
		
		homePage = customerPage.clickToLogoutLink();
	}

	@Test
	public void Register_04_Existing_Email() {
		
		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Hana");
		registerPage.enterToLastNameTextbox("Olala");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getExistingEmailErrorTextMessage(), "account.register.errors.emailalreadyexists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Characters() {
		
		homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Hana");
		registerPage.enterToLastNameTextbox("Hasta");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("1234");
		registerPage.enterToConfirmPasswordTextbox("1234");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getInvalidPasswordTextMessage(), "validation.password.rule");
	}

	@Test
	public void Register_06_Not_Matching_Password() {
		homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("Hana");
		registerPage.enterToLastNameTextbox("Hasta");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("12345678");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorTextMessage(), "account.fields.password.enteredpasswordsdonotmatch");

	}



	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
