package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import pageUIs.admin.AdminCatalogProductsPageUI;

public class AdminCatalogProductsPageObject extends AdminDashboardSideBarPageObject{
	WebDriver driver;
	public AdminCatalogProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void searchByCategory(String categoryName) {
		waitForElementClickable(driver, AdminCatalogProductsPageUI.SEARCH_CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductsPageUI.SEARCH_CATEGORY_DROPDOWN, categoryName);
		
		waitForElementClickable(driver, AdminCatalogProductsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCatalogProductsPageUI.SEARCH_BUTTON);
	}
}
