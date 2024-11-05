package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.user.CustomerAddressObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.DownloadableProductObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointsObject;
import pageObjects.user.UserLoginPageObject;

public class PageGeneratorManager {

	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static CustomerPageObject getCustomerPageObject(WebDriver driver) {
		return new CustomerPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static RewardPointsObject getRewardPointsPage(WebDriver driver) {
		return new RewardPointsObject(driver) ;
	}

	public static DownloadableProductObject getDownloadableProductPage(WebDriver driver) {
		return new DownloadableProductObject(driver);
	}
	
	public static CustomerAddressObject getCustomerAddressObject(WebDriver driver) {
		return new CustomerAddressObject(driver);
	}

}
