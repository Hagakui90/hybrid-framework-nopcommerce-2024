package pageObjects.admin;

import java.util.ArrayList;
import java.util.Collections;
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

	public List<String> getListNameProductSortedByCreatedOnAllPage(){
		List<String> listNameProductPerCatalogProductAllPage = new ArrayList<String>();
		for (Product product : sortAsCreatedOnByCatalogProduct()) {
			listNameProductPerCatalogProductAllPage.add(product.getTitleOfProduct());
		}
		return listNameProductPerCatalogProductAllPage;
	}
	
	public List<Product> listCreatedOnPerCatalogProductAllPage() {
		List<Product> listCreatedOnPerCatalogProductAllPage = new ArrayList<Product>();
		String currentNumberPage = getElementText(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		System.out.println("currentNumberPage " + currentNumberPage);
		System.out.println("-----------------SELECT EACH PRODUCT TO GET CREATED DATE------------------");
		listCreatedOnPerCatalogProductAllPage = getListCreatedOnPerCatalogProductEachPage();
		while (isNextPageButtonActived(currentNumberPage)) {
			waitForElementVisible(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT, currentNumberPage);
			clickToElementByJS(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT, currentNumberPage);
			for (Product product : getListCreatedOnPerCatalogProductEachPage()) {
				listCreatedOnPerCatalogProductAllPage.add(product);
			}
			currentNumberPage = getElementText(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		}
		return listCreatedOnPerCatalogProductAllPage;
	}

	public List<Product> getListCreatedOnPerCatalogProductEachPage() {
		int columnIndex = getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.common.edit") + 1;
		List<WebElement> listResultProductEachPage = getListWebElement(driver, AdminCatalogProductsPageUI.ALL_VALUES_BY_COLUMN_INDEX, String.valueOf(columnIndex));
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
		return adminEditProductDetailsPage.getInforCreatedOnProduct();

	}

	public void viewlistCreatedOnPerCatalogProductEachPage(String noProduct) {
		List<Product> listCreatedOnPerCatalogProductEachPage = getListCreatedOnPerCatalogProductEachPage();
		for (Product product : listCreatedOnPerCatalogProductEachPage) {
			System.out.println("Product " + noProduct + product.getTitleOfProduct() + " " + product.getCreatedOn());
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
		 Collections.sort((List<Product>) listCreatedOnPerCatalogProductAllPage);
		 System.out.println("---------------After sorted, List product-----------------");
		 for (Product product : listCreatedOnPerCatalogProductAllPage) {
			System.out.println(product.getTitleOfProduct() + "===========" + product.getCreatedOn());
		}
		return listCreatedOnPerCatalogProductAllPage;
	}

	public void searchByName(String productName) {
		waitForElementVisible(driver, AdminCatalogProductsPageUI.SEARCH_INFO_TEXTBOX_BY_NAME, "SearchProductName");
		sendkeyToElement(driver, AdminCatalogProductsPageUI.SEARCH_INFO_TEXTBOX_BY_NAME, productName, "SearchProductName");
		
		waitForElementClickable(driver, AdminCatalogProductsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCatalogProductsPageUI.SEARCH_BUTTON);
	}
	
	public List<Product> getListProductSearchByName() {
		waitForElementVisible(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		String currentNumberPage = getElementText(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		String nameColumnIndex = String.valueOf(getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.catalog.products.fields.name") + 1);
		String skuColumnIndex = String.valueOf(getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.catalog.products.fields.sku") + 1);
		String priceColumnIndex = String.valueOf(getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.catalog.products.fields.price") + 1);
		String stockQuantityColumnIndex = String.valueOf(getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.catalog.products.fields.stockquantity") + 1);
		String publishedColumnIndex = String.valueOf(getListElementSize(driver, AdminCatalogProductsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "admin.catalog.products.fields.published") + 1);
		List<WebElement> listProductResult = getListWebElement(driver, AdminCatalogProductsPageUI.LIST_PRODUCT_SEARCH);
		List<Product> listProduct = new ArrayList<Product>();
		do {
			for (int i = 0; i < listProductResult.size(); i++) {
				String rowIndex = String.valueOf(i + 1);
				waitForElementVisible(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, nameColumnIndex);
				waitForElementVisible(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, skuColumnIndex);
				waitForElementVisible(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, priceColumnIndex);
				waitForElementVisible(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, stockQuantityColumnIndex);
				waitForElementVisible(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, publishedColumnIndex);
				String nameProduct = getElementText(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, nameColumnIndex);
				String skuProduct = getElementText(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, skuColumnIndex);
				String priceProduct = getElementText(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, priceColumnIndex);
				String stockQuantity = getElementText(driver, AdminCatalogProductsPageUI.VALUE_BY_ROW_INDEX_COLUMN_INDEX, rowIndex, stockQuantityColumnIndex);
				boolean statusOfPublished = Boolean.valueOf(getElementAttribute(driver, AdminCatalogProductsPageUI.PUBLISH_ICON_BY_ROW_INDEX_COLUMN_INDEX, "nop-value", rowIndex, publishedColumnIndex));
				Product product = new Product(skuProduct, nameProduct, priceProduct, stockQuantity, statusOfPublished);
				listProduct.add(product);
			}
			waitForElementVisible(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT, currentNumberPage);
			clickToElementByJS(driver, AdminCatalogProductsPageUI.NEXT_PAGE_LINK_TEXT, currentNumberPage);
			currentNumberPage = getElementText(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		}while (isNextPageButtonActived(currentNumberPage));
		
		return listProduct;
	}

	public void searchByNameAndCategory(String productName, String categoryName, String subCategories, String manufacturer) {
		waitForElementVisible(driver, AdminCatalogProductsPageUI.SEARCH_INFO_TEXTBOX_BY_NAME, "SearchProductName");
		sendkeyToElement(driver, AdminCatalogProductsPageUI.SEARCH_INFO_TEXTBOX_BY_NAME, productName, "SearchProductName");
		waitForElementClickable(driver, AdminCatalogProductsPageUI.SEARCH_CATEGORY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductsPageUI.SEARCH_CATEGORY_DROPDOWN, categoryName);
		waitForElementVisible(driver, AdminCatalogProductsPageUI.SUB_CATEGORIES_CHECKBOX);
		if (subCategories.equals("Yes")) {
			checkToElement(driver, AdminCatalogProductsPageUI.SUB_CATEGORIES_CHECKBOX);
		}else {
			uncheckToElement(driver, AdminCatalogProductsPageUI.SUB_CATEGORIES_CHECKBOX);
		}
		
		waitForElementClickable(driver, AdminCatalogProductsPageUI.MANUFACTURER_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminCatalogProductsPageUI.MANUFACTURER_DROPDOWN, manufacturer);
		
		waitForElementClickable(driver, AdminCatalogProductsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCatalogProductsPageUI.SEARCH_BUTTON);
	}

	public String getEmptyTableText() {
		waitForElementVisible(driver, AdminCatalogProductsPageUI.EMPTY_TABLE_TEXT);
		return getElementText(driver, AdminCatalogProductsPageUI.EMPTY_TABLE_TEXT);
	}
	
	public AdminEditProductDetailsPageObject searchBySku(String sku) {
		waitForElementVisible(driver, AdminCatalogProductsPageUI.SEARCH_INFO_TEXTBOX_BY_NAME, "GoDirectlyToSku");
		sendkeyToElement(driver, AdminCatalogProductsPageUI.SEARCH_INFO_TEXTBOX_BY_NAME, sku, "GoDirectlyToSku");
		waitForElementClickable(driver, AdminCatalogProductsPageUI.GO_BUTTON);
		clickToElement(driver, AdminCatalogProductsPageUI.GO_BUTTON);
		return PageGeneratorManager.getAdminEditProductDetailsPage(driver);
	}
	
	
	
}
