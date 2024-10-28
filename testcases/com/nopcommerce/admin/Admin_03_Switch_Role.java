package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;


public class Admin_03_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userEmailAddress = "afc3574@mail.vn";
	private String adminEmailAdress = "hagakui90@gmail.com";
	private String userUrl, adminUrl;

	private HomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters({"browser", "userUrl", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {

		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
		driver = getBrowserDriver(browserName, this.userUrl);
		homePage = PageGeneratorManager.getHomePageObject(driver);

	}

	@Test
	public void Switch_Role_01_User_To_Admin() {
		userLoginPage = homePage.clickToLoginLink();
		
		homePage = userLoginPage.enterToLoginForm(userEmailAddress, "123456");
		
		homePage.openPageUrl(driver, this.adminUrl);
		Assert.assertTrue(homePage.isPageLoadedSuccess(driver));
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage = adminLoginPage.enterToLoginForm(adminEmailAdress, "hagakui90");
		

	}
}
