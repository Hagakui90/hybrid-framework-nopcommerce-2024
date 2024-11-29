package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminCatalogProductsPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminEditProductDetailsPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.guest.BooksCategoryPageObject;
import pageObjects.guest.ComputersCategoryPageObject;
import pageObjects.guest.NotebooksSubPageObject;
import pageObjects.user.CartPageObject;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.CompareProductsPageObject;
import pageObjects.user.CustomerAddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.CustomerProductReviewPageObject;
import pageObjects.user.CustomerSearchPageObject;
import pageObjects.user.DesktopsSubPageObject;
import pageObjects.user.DetailProductPageObject;
import pageObjects.user.DownloadableProductPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RecentlyViewedProductsPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.RewardPointsPageObject;
import pageObjects.user.SoftwareSubPageObject;
import pageObjects.user.UserLoginPageObject;
import pageObjects.user.WishlistPageObject;

public class PageGeneratorManager {

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static CustomerPageObject getCustomerPage(WebDriver driver) {
		return new CustomerPageObject(driver);
	}

	public static DesktopsSubPageObject getDesktopsSubPage(WebDriver driver) {
		return new DesktopsSubPageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}

	public static RewardPointsPageObject getRewardPointsPage(WebDriver driver) {
		return new RewardPointsPageObject(driver);
	}

	public static DownloadableProductPageObject getDownloadableProductPage(WebDriver driver) {
		return new DownloadableProductPageObject(driver);
	}

	public static CustomerAddressPageObject getCustomerAddress(WebDriver driver) {
		return new CustomerAddressPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePassword(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static DetailProductPageObject getDetailProductPage(WebDriver driver) {
		return new DetailProductPageObject(driver);
	}

	public static CustomerProductReviewPageObject getCustomerProductReviewPage(WebDriver driver) {
		return new CustomerProductReviewPageObject(driver);
	}

	public static CustomerSearchPageObject getCustomerSearchPage(WebDriver driver) {
		return new CustomerSearchPageObject(driver);
	}

	public static ComputersCategoryPageObject getComputersPage(WebDriver driver) {
		return new ComputersCategoryPageObject(driver);
	}

	public static NotebooksSubPageObject getNotebooksSubPage(WebDriver driver) {
		return new NotebooksSubPageObject(driver);
	}

	public static BooksCategoryPageObject getBooksCategoryPage(WebDriver driver) {
		return new BooksCategoryPageObject(driver);
	}

	public static AdminCatalogProductsPageObject getAdminCatalogProductPage(WebDriver driver) {
		return new AdminCatalogProductsPageObject(driver);
	}

	public static AdminEditProductDetailsPageObject getAdminEditProductDetailsPage(WebDriver driver) {
		return new AdminEditProductDetailsPageObject(driver);
	}

	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);
	}

	public static CartPageObject getCartPage(WebDriver driver) {
		return new CartPageObject(driver);
	}

	public static CompareProductsPageObject getCompareProductsPage(WebDriver driver) {
		return new CompareProductsPageObject(driver);
	}

	public static RecentlyViewedProductsPageObject getRecentlyViewedProductsPage(WebDriver driver) {
		return new RecentlyViewedProductsPageObject(driver);
	}

	public static SoftwareSubPageObject getSoftwareSubPage(WebDriver driver) {
		return new SoftwareSubPageObject(driver);
	}
}
