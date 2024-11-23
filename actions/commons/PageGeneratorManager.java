package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminCatalogProductsPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminEditProductDetailsPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.guest.BooksCategoryPageObject;
import pageObjects.guest.ComputersCategoryPageObject;
import pageObjects.guest.NotebooksSubPageObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.CustomerAddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.CustomerProductReviewPageObject;
import pageObjects.user.CustomerSearchPageObject;
import pageObjects.user.DetailProductPageObject;
import pageObjects.user.DownloadableProductPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointsPageObject;
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

	public static RewardPointsPageObject getRewardPointsPage(WebDriver driver) {
		return new RewardPointsPageObject(driver) ;
	}

	public static DownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {
		return new DownloadableProductPageObject(driver);
	}
	
	public static CustomerAddressPageObject getCustomerAddressObject(WebDriver driver) {
		return new CustomerAddressPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordObject(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static DetailProductPageObject getDetailProductPage(WebDriver driver) {
		return new DetailProductPageObject(driver);
	}

	public static CustomerProductReviewPageObject getCustomerProductReviewPageObject(WebDriver driver) {
		return new CustomerProductReviewPageObject(driver);
	}

	public static CustomerSearchPageObject getCustomerSearchPageObject(WebDriver driver) {
		return new CustomerSearchPageObject(driver);
	}
	
	public static ComputersCategoryPageObject getComputersPageObject(WebDriver driver) {
		return new ComputersCategoryPageObject(driver);
	}

	public static NotebooksSubPageObject getNotebooksSubPage(WebDriver driver) {
		return new NotebooksSubPageObject(driver);
	}

	public static BooksCategoryPageObject getBooksSubPageObject(WebDriver driver) {
		return new BooksCategoryPageObject(driver);
	}

	public static AdminCatalogProductsPageObject getAdminCatalogProductPage(WebDriver driver) {
		return new AdminCatalogProductsPageObject(driver);
	}

	public static AdminEditProductDetailsPageObject getAdminEditProductDetailsPage(WebDriver driver) {
		return new AdminEditProductDetailsPageObject(driver);		
	}
	
}
