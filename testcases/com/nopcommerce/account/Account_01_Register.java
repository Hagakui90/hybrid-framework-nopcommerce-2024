package com.nopcommerce.account;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

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
		homePage = new HomePageObject(driver);
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

	}

	@Test
	public void Register_01_Empty() {
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFirstNameErrorTextMessage(), "account.fields.firstname.required");
		Assert.assertEquals(registerPage.getLastNameErrorTextMessage(), "account.fields.lastname.required");
		Assert.assertEquals(registerPage.getEmailErrorTextMessage(), "account.fields.email.required");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorTextMessage(), "account.fields.confirmpassword.required");

	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

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
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.enterToFirstNameTextbox("Hana");
		registerPage.enterToLastNameTextbox("Hasta");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getCompletedRegisterTextMessage(), "account.register.result.standard");
		registerPage.clickToMyAccountLink();

		customerPage = new CustomerPageObject(driver);
		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "Hana");
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "Hasta");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);

		customerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void Register_04_Existing_Email() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

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
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

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
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

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
