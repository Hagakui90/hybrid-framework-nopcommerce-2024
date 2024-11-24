package pageObjects.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.PageGeneratorManager;
import commons.Product;
import pageUIs.admin.AdminCatalogProductsPageUI;

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

	public List<Product> listCreatedOnPerCatalogProductAllPage() {
		List<Product> listCreatedOnPerCatalogProductAllPage = new ArrayList<Product>();
		String currentNumberPage = getElementText(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		System.out.println("currentNumberPage " + currentNumberPage);
		System.out.println("-----------------------");
		System.out.println("LatestCreatedOnPerProductOfOnePage: ");
		listCreatedOnPerCatalogProductAllPage = getListCreatedOnPerCatalogProductEachPage();
		while (isNextPageButtonActived(currentNumberPage)) {
			waitForElementVisible(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT);
			clickToElementByJS(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT);
			for (Product product : getListCreatedOnPerCatalogProductEachPage()) {
				listCreatedOnPerCatalogProductAllPage.add(product);
			}
			currentNumberPage = getElementText(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		}
		return listCreatedOnPerCatalogProductAllPage;
	}

	public List<Product> getListCreatedOnPerCatalogProductEachPage() {
		System.out.println("-----------SELECT EACH PRODUCT TO GET CREATED DATE----------------");
		int columnIndex = getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.common.edit") + 1;
		System.out.println("Column index: " + String.valueOf(columnIndex));
		List<WebElement> listResultProductEachPage = getListWebElement(driver, AdminCatalogProductsPageUI.ALL_VALUES_COLUMN_INDEX, String.valueOf(columnIndex));
		List<Product> listCreatedOnPerCatalogProductEachPage = new ArrayList<Product>();
		for (int i = 1; i <= listResultProductEachPage.size(); i++) {
			listCreatedOnPerCatalogProductEachPage.add(clickToEveryEditButtonProduct(String.valueOf(i)));
			viewlistCreatedOnPerCatalogProductEachPage(String.valueOf(i));
			backToPage(driver);
			adminEditProductDetailsPage = PageGeneratorManager.getAdminEditProductDetailsPage(driver);
		}
		return listCreatedOnPerCatalogProductEachPage;
	}

	public Product clickToEveryEditButtonProduct(String noProduct) {
		searchByCategory("Books");
		isPageLoadedSuccess(driver);
		PageGeneratorManager.getAdminCatalogProductPage(driver);
		int columnIndex = getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.common.edit") + 1;
		waitForElementClickable(driver, AdminCatalogProductsPageUI.EDIT_BUTTON_BY_NO_NAME, noProduct, String.valueOf(columnIndex));
		clickToElement(driver, AdminCatalogProductsPageUI.EDIT_BUTTON_BY_NO_NAME, noProduct, String.valueOf(columnIndex));
		adminEditProductDetailsPage = PageGeneratorManager.getAdminEditProductDetailsPage(driver);
		isPageLoadedSuccess(driver);
		System.out.println("Open product: ");
		return adminEditProductDetailsPage.getInforCreatedOnProduct();

	}

	public void viewlistCreatedOnPerCatalogProductEachPage(String noProduct) {
		List<Product> listCreatedOnPerCatalogProductEachPage = getListCreatedOnPerCatalogProductEachPage();
		for (Product product : listCreatedOnPerCatalogProductEachPage) {
			System.out.println("Product " + noProduct + product.getTitleOfBook() + " " + product.getCreatedOn());
		}
	}

	public boolean isNextPageButtonActived(String currentNumberPage) {
		waitForElementVisible(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT);
		if (getElementAttribute(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT, "class").contains("disabled")) {
			System.out.println("Next button is not actived.");
			return false;
		} else
			return true;
	}

	public List<Product> sortAsCreatedOnByCatalogProduct() {
		List<Product> listCreatedOnPerCatalogProductAllPage = listCreatedOnPerCatalogProductAllPage();
		// Collections.sort((List<Product>) listCreatedOnPerCatalogProductAllPage);
		for (int i = 0; i < listCreatedOnPerCatalogProductAllPage.size(); i++) {
			
		} {
			
		}
		return listCreatedOnPerCatalogProductAllPage;
	}

}
