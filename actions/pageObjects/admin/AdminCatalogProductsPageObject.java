package pageObjects.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.PageGeneratorManager;
import pageUIs.admin.AdminCatalogProductsPageUI;

public class AdminCatalogProductsPageObject extends AdminDashboardSideBarPageObject{
	WebDriver driver;
	AdminEditProductDetailsPageObject adminEditProductDetailsPage;
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
	
	public void clickEditIconByColumnName(String columnName) {
		List<WebElement> listResultProduct = getListWebElement(driver, AdminCatalogProductsPageUI.ALL_VALUES_COLUMN_INDEX, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.common.edit");
		
		for (int i = 0; i < listResultProduct.size(); i++) {
			listResultProduct.get(i).click();
			isPageLoadedSuccess(driver);
			adminEditProductDetailsPage = PageGeneratorManager.getAdminEditProductDetailsPage(driver);
			adminEditProductDetailsPage.expandDetailItemByCardName("quantityhistory");
			List<Date> detailsCreatedOn = new ArrayList<Date>();
			detailsCreatedOn = adminEditProductDetailsPage.getDetailsItemByCardNameAndValueName("quantityhistory", "createdon");
			Collections.sort(detailsCreatedOn);
		}
	}
	
	
}
