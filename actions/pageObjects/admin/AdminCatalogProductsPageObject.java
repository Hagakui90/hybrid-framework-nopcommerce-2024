package pageObjects.admin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.PageGeneratorManager;
import commons.Product;
import pageUIs.admin.AdminCatalogProductsPageUI;
import pageUIs.admin.AdminEditProductDetailsPageUI;

public class AdminCatalogProductsPageObject extends AdminDashboardSideBarPageObject {
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

	public List<Product> getListCreatedOnPerCatalogProductEachPage() {
		System.out.println("Select every product");
		int columnIndex = getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.common.edit") + 1;
		System.out.println("Column index: " + String.valueOf(columnIndex));
		List<WebElement> listResultProductEachPage = getListWebElement(driver, AdminCatalogProductsPageUI.ALL_VALUES_COLUMN_INDEX, String.valueOf(columnIndex));
		List<Product> listCreatedOnPerCatalogProductEachPage = new ArrayList<Product>();
		for (WebElement result : listResultProductEachPage) {
			result.click();
			adminEditProductDetailsPage = PageGeneratorManager.getAdminEditProductDetailsPage(driver);
			isPageLoadedSuccess(driver);
			System.out.println("Open product: ");
			listCreatedOnPerCatalogProductEachPage.add(adminEditProductDetailsPage.getInforCreatedOnProduct());
			viewlistCreatedOnPerCatalogProductEachPage();
			backToPage(driver);
			PageGeneratorManager.getAdminCatalogProductPage(driver);
			searchByCategory("Books");
			isPageLoadedSuccess(driver);
		}
		return listCreatedOnPerCatalogProductEachPage;
	}
	
	public void viewlistCreatedOnPerCatalogProductEachPage() {
		List<Product> listCreatedOnPerCatalogProductEachPage = getListCreatedOnPerCatalogProductEachPage();
		for (Product product : listCreatedOnPerCatalogProductEachPage) {
			System.out.println(product.getTitleOfBook() + " " + product.getCreatedOn());
		}
	}
	
	public boolean isNextPageButtonActived(String currentNumberPage) {
		waitForElementVisible(driver, AdminEditProductDetailsPageUI.NEXT_BUTTON_EACH_CARD_BY_NUMBER_PAGE, "stockquantityhistory", currentNumberPage);
		return isElementDisplayed(driver, AdminEditProductDetailsPageUI.NEXT_BUTTON_EACH_CARD_BY_NUMBER_PAGE, "stockquantityhistory", currentNumberPage);
	} 

	public List<Product> sortAsCreatedOnByCatalogProduct() {
		List<Product> lastestCreatedOnPerCatalogProduct = getListCreatedOnPerCatalogProductEachPage();
		/* Collections.sort(lastestCreatedOnPerCatalogProduct.); */
		return lastestCreatedOnPerCatalogProduct;
	}

}
