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
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Account_02_Login extends BaseTest{
	private WebDriver driver;
	private String emailAddress = "afc3574@mail.vn";

	private HomePageObject homePage;
	private CustomerPageObject customerPage;
	private UserLoginPageObject userLoginPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void Login_01_Empty() {

	}

	@Test
	public void Login_02_Invalid_Email() {

	}

	@Test
	public void Login_03_Not_Exist_Email() {

	}

	@Test
	public void Login_04_Existing_Email_Not_Input_Password() {

	}

	@Test
	public void Login_05_Existing_Email_Wrong_Password() {

	}

	@Test
	public void Login_06_Successful() {
		userLoginPage = homePage.clickToLoginLink();
		
		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("123456");
		
		homePage = userLoginPage.clickToLoginButton();
		
		customerPage = homePage.clickToMyAccountLink();
		
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
			
		
	}

	@AfterClass
	public void afterClass() {

	}

}
