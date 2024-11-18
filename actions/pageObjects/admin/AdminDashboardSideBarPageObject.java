package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminDashboardSideBarPageUI;
import pageUIs.guest.CategoriesSideBarPageUI;

public class AdminDashboardSideBarPageObject extends BasePage{
	WebDriver driver;
	public AdminDashboardSideBarPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openAdminDashBoardSideBarPage(String categoryName, String subCategoryName) {
		if (!subCategoryName.equals("")) {
			waitForElementClickable(driver, AdminDashboardSideBarPageUI.DYNAMIC_ADMIN_SIDEBAR_LINK_TEXT, categoryName);
			clickToElement(driver, AdminDashboardSideBarPageUI.DYNAMIC_ADMIN_SIDEBAR_LINK_TEXT, categoryName);
			waitForElementClickable(driver, AdminDashboardSideBarPageUI.DYNAMIC_SUBMENU_ADMIN_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
			clickToElement(driver, AdminDashboardSideBarPageUI.DYNAMIC_SUBMENU_ADMIN_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
		}
		else {
			waitForElementClickable(driver, AdminDashboardSideBarPageUI.DYNAMIC_ADMIN_SIDEBAR_LINK_TEXT, categoryName);
			clickToElement(driver, AdminDashboardSideBarPageUI.DYNAMIC_ADMIN_SIDEBAR_LINK_TEXT, categoryName);
		}
	}
}
