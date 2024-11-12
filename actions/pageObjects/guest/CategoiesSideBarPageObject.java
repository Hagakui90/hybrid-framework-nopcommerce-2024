package pageObjects.guest;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.guest.CategoriesSideBarPageUI;

public class CategoiesSideBarPageObject extends BasePage{
	WebDriver driver;
	public CategoiesSideBarPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void openCategoriesSideBarPage(String categoryName, String subCategoryName) {
		waitForElementClickable(driver, CategoriesSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
		clickToElement(driver, CategoriesSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
	}
	
	public String getPageTitle() {
		waitForElementVisible(driver, CategoriesSideBarPageUI.PAGE_TITLE_TEXT);
		return getElementText(driver, CategoriesSideBarPageUI.PAGE_TITLE_TEXT);
	}
	
}
