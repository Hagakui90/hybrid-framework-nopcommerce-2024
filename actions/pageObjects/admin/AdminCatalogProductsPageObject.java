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
import pageUIs.admin.AdminEditProductDetailsPageUI;

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
	
	public List<Date> getListCreatedOnPerCatalogProductPage() {
		List<WebElement> listResultProductPerPage = getListWebElement(driver, AdminCatalogProductsPageUI.ALL_VALUES_COLUMN_INDEX, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.common.edit");
		List<Date> listCreatedOnPerCatalogProductPage = new ArrayList<Date>();
		for (int i = 0; i < listResultProductPerPage.size(); i++) {
			listResultProductPerPage.get(i).click();
			isPageLoadedSuccess(driver);
			adminEditProductDetailsPage.getLatestCreatedOnPerProduct();
		}
		return listCreatedOnPerCatalogProductPage;
	}
	
	public Date getLatestCreatedOnByCatalogProduct() {
		List<Date> lastestCreatedOnPerCatalogProduct = getListCreatedOnPerCatalogProductPage();
		Collections.sort(lastestCreatedOnPerCatalogProduct);
		return lastestCreatedOnPerCatalogProduct.get(lastestCreatedOnPerCatalogProduct.size() - 1);
	}
	
	
}
