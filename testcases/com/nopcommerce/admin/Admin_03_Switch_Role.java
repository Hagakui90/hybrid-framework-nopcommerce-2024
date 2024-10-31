package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;


public class Admin_03_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress = "afc3574@mail.vn";
	private String userUrl = GlobalConstants.DEV_USER_URL;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

	private HomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, userUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);

	}

	@Test
	public void Switch_Role_01_User_To_Admin() {
		userLoginPage = homePage.clickToLoginLink();
		
		homePage = userLoginPage.enterToLoginForm(userEmailAddress, "123456");
		
		homePage.openPageUrl(driver, adminUrl);
		Assert.assertTrue(homePage.isPageLoadedSuccess(driver));
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage = adminLoginPage.enterToLoginForm(GlobalConstants.DEV_ADMIN_USERNAME, GlobalConstants.DEV_ADMIN_PASSWORD);
		

	}
}
