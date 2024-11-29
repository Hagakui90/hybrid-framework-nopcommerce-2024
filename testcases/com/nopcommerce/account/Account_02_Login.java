package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.DownloadableProductPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RewardPointsPageObject;
import pageObjects.user.UserLoginPageObject;

public class Account_02_Login extends BaseTest {
	private WebDriver driver;
	private String emailAddress = "afc3574@mail.vn";

	private HomePageObject homePage;
	private CustomerPageObject customerPage;
	private UserLoginPageObject userLoginPage;
	private RewardPointsPageObject rewardPointsPage;
	private DownloadableProductPageObject downloadableProductPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Login_01_Empty() {
		userLoginPage = homePage.clickToLoginLink();

		userLoginPage.enterToEmailAddress("");
		userLoginPage.enterToPassword("");
		userLoginPage.clickToLoginButton();
		Assert.assertEquals(userLoginPage.getEmailErrorTextMessage(), "account.login.fields.email.required");
	}

	@Test
	public void Login_02_Invalid_Email() {
		userLoginPage.enterToEmailAddress("123456");
		Assert.assertEquals(userLoginPage.getEmailErrorTextMessage(), "Please enter a valid email address.");
	}

	@Test
	public void Login_03_Not_Exist_Email() {
		userLoginPage.enterToEmailAddress("afc357@mail.vn");
		userLoginPage.enterToPassword("123456");
		userLoginPage.clickToLoginButton();
		System.out.println(userLoginPage.getEmailNotExistTextMessage());
		Assert.assertTrue(userLoginPage.getEmailNotExistTextMessage().contains("account.login.unsuccessful\naccount.login.wrongcredentials.customernotexist"));
	}

	@Test
	public void Login_04_Existing_Email_Not_Input_Password() {
		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("");
		userLoginPage.clickToLoginButton();
		Assert.assertTrue(userLoginPage.getEmailNotExistTextMessage().contains("account.login.unsuccessful\naccount.login.wrongcredentials"));
	}

	@Test
	public void Login_05_Existing_Email_Wrong_Password() {
		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("23456");
		userLoginPage.clickToLoginButton();
		Assert.assertTrue(userLoginPage.getEmailNotExistTextMessage().contains("account.login.unsuccessful\naccount.login.wrongcredentials"));
	}

	@Test
	public void Login_06_Successful() {
		userLoginPage = homePage.clickToLoginLink();

		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("123456");

		homePage = userLoginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("Email"), emailAddress);
	}

	@Test
	public void Login_07_Page_Navigation() {
		customerPage.openDynamicSideBarPage("account.rewardpoints");
		rewardPointsPage = PageGeneratorManager.getRewardPointsPage(driver);

		rewardPointsPage.openDynamicSideBarPage("account.downloadableproducts");
		downloadableProductPage = PageGeneratorManager.getDownloadableProductPage(driver);
	}

	@AfterClass
	public void afterClass() {

	}

}
