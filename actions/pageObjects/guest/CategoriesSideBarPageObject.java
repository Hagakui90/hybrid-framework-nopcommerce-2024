package pageObjects.guest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.guest.CategoriesSideBarPageUI;

public class CategoriesSideBarPageObject extends BasePage {
	WebDriver driver;

	public CategoriesSideBarPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void openCategoriesSideBarPage(String categoryName, String subCategoryName) {
		if (!subCategoryName.equals("")) {
			waitForElementClickable(driver, CategoriesSideBarPageUI.DYNAMIC_CATEGORY_SIDEBAR_LINK_TEXT, categoryName);
			clickToElement(driver, CategoriesSideBarPageUI.DYNAMIC_CATEGORY_SIDEBAR_LINK_TEXT, categoryName);
			waitForElementClickable(driver, CategoriesSideBarPageUI.DYNAMIC_SUBMENU_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
			clickToElement(driver, CategoriesSideBarPageUI.DYNAMIC_SUBMENU_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
		} else {
			waitForElementClickable(driver, CategoriesSideBarPageUI.DYNAMIC_CATEGORY_SIDEBAR_LINK_TEXT, categoryName);
			clickToElement(driver, CategoriesSideBarPageUI.DYNAMIC_CATEGORY_SIDEBAR_LINK_TEXT, categoryName);
		}
	}

	public String getPageTitle() {
		waitForElementVisible(driver, CategoriesSideBarPageUI.PAGE_TITLE_TEXT);
		return getElementText(driver, CategoriesSideBarPageUI.PAGE_TITLE_TEXT);
	}

	public boolean verifySortNameAscending() {
		waitForElementClickable(driver, CategoriesSideBarPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CategoriesSideBarPageUI.SORT_DROPDOWN, "Name Asc");
		sleepInSecond(5);
		List<WebElement> listProduct = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_TITLE_LIST_TEXT)));

		List<String> actualProductName = new ArrayList<String>();
		for (WebElement product : listProduct) {
			actualProductName.add(product.getText());
		}
		logSort(actualProductName);
		List<String> expectedProductName = new ArrayList<String>();
		for (String productName : actualProductName) {
			expectedProductName.add(productName);
		}
		Collections.sort(expectedProductName);
		logSort(expectedProductName);
		return actualProductName.equals(expectedProductName);
	}

	public boolean verifySortNameDescending() {
		waitForElementClickable(driver, CategoriesSideBarPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CategoriesSideBarPageUI.SORT_DROPDOWN, "Name Desc");
		sleepInSecond(5);
		List<WebElement> listProduct = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_TITLE_LIST_TEXT)));
		List<String> actualProductName = new ArrayList<String>();
		for (WebElement product : listProduct) {
			actualProductName.add(product.getText());
		}
		logSort(actualProductName);
		List<String> expectedProductName = new ArrayList<String>();
		for (String productName : actualProductName) {
			expectedProductName.add(productName);
		}
		Collections.sort(expectedProductName);
		Collections.reverse(expectedProductName);
		return actualProductName.equals(expectedProductName);
	}

	public void logSort(List<String> list) {
		for (String l : list) {
			System.out.println(l);
			System.out.println("==========================");

		}
	}

	public boolean verifySortPriceAscending() {
		waitForElementClickable(driver, CategoriesSideBarPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CategoriesSideBarPageUI.SORT_DROPDOWN, "Price Asc");
		sleepInSecond(5);
		List<WebElement> listProduct = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_PRICE_LIST_TEXT)));
		List<Float> actualProductPrice = new ArrayList<Float>();
		for (WebElement product : listProduct) {
			String formatedProductPrice = product.getText().replace("$", "");
			formatedProductPrice = formatedProductPrice.replace(",", "");
			actualProductPrice.add(Float.parseFloat(formatedProductPrice));
		}
		List<Float> expectedProductPrice = new ArrayList<Float>();
		for (Float productPrice : actualProductPrice) {
			expectedProductPrice.add(productPrice);
		}
		Collections.sort(expectedProductPrice);
		return actualProductPrice.equals(expectedProductPrice);
	}

	public boolean verifySortPriceDescending() {
		waitForElementClickable(driver, CategoriesSideBarPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CategoriesSideBarPageUI.SORT_DROPDOWN, "Price Desc");
		sleepInSecond(5);
		List<WebElement> listProduct = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_PRICE_LIST_TEXT)));
		List<Float> actualProductPrice = new ArrayList<Float>();
		for (WebElement product : listProduct) {
			String formatedProductPrice = product.getText().replace("$", "");
			formatedProductPrice = formatedProductPrice.replace(",", "");
			actualProductPrice.add(Float.parseFloat(formatedProductPrice));
		}
		List<Float> expectedProductPrice = new ArrayList<Float>();
		for (Float productPrice : actualProductPrice) {
			expectedProductPrice.add(productPrice);
		}
		Collections.sort(expectedProductPrice);
		Collections.reverse(expectedProductPrice);
		return actualProductPrice.equals(expectedProductPrice);
	}

	public List<String> getListNameProductByCreatedOnAtGuestSite() {
		waitForElementClickable(driver, CategoriesSideBarPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, CategoriesSideBarPageUI.SORT_DROPDOWN, "Created On");
		sleepInSecond(3);

		List<String> listNameProductByCreatedOnAtGuestSite = new ArrayList<String>();
		List<String> listNameProductByCreatedOnAllPage = getListNameProductByCreatedOnAllPage();
		for (String nameProduct : listNameProductByCreatedOnAllPage) {
			listNameProductByCreatedOnAtGuestSite.add(nameProduct);
		}
		return listNameProductByCreatedOnAtGuestSite;
	}

	public List<String> getListNameProductByCreatedOnAllPage() {
		List<String> listNameProductByCreatedOnAllPage = new ArrayList<String>();
		String currentNumberPage = getElementText(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
		System.out.println("currentNumberPage: " + currentNumberPage);
		listNameProductByCreatedOnAllPage = getListNameProductByCreatedOnEachPage();
		while (isNextPageButtonActived(currentNumberPage)) {
			System.out.println("Next page is actived.");
			waitForElementClickable(driver, CategoriesSideBarPageUI.NEXT_PAGE_BUTTON_BY_NAME, currentNumberPage);
			clickToElement(driver, CategoriesSideBarPageUI.NEXT_PAGE_BUTTON_BY_NAME, currentNumberPage);
			sleepInSecond(5);
			for (String nameProduct : getListNameProductByCreatedOnEachPage()) {
				listNameProductByCreatedOnAllPage.add(nameProduct);
			}
			currentNumberPage = getElementText(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
			System.out.println("currentNumberPage: " + currentNumberPage);
		}
		return listNameProductByCreatedOnAllPage;
	}

	public boolean isNextPageButtonActived(String currentNumberPage) {
		if (currentNumberPage.equalsIgnoreCase("Current page")) {
			waitForElementVisible(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
			currentNumberPage = getElementText(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
		}
		if (isElementUndisplayed(driver, CategoriesSideBarPageUI.NEXT_PAGE_BUTTON_BY_NAME, currentNumberPage)) {
			return false;
		} else
			// waitForElementVisible(driver, CategoriesSideBarPageUI.NEXT_PAGE_BUTTON_BY_NAME, currentNumberPage);
			return isElementDisplayed(driver, CategoriesSideBarPageUI.NEXT_PAGE_BUTTON_BY_NAME, currentNumberPage);
	}

	public List<String> getListNameProductByCreatedOnEachPage() {
		List<String> listNameProductByCreatedOnEachPage = new ArrayList<String>();
		List<WebElement> getListProductByCreatedOnEachPage = getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_TITLE_LIST_TEXT);
		for (WebElement product : getListProductByCreatedOnEachPage) {
			System.out.print(product.getText() + "\t");
			listNameProductByCreatedOnEachPage.add(product.getText());

		}
		return listNameProductByCreatedOnEachPage;
	}

	public boolean verifyPaging(String pageSize) {
		waitForElementClickable(driver, CategoriesSideBarPageUI.PAGE_SIZE_DROPDOWN);
		selectItemInDefaultDropdown(driver, CategoriesSideBarPageUI.PAGE_SIZE_DROPDOWN, pageSize);
		sleepInSecond(3);

		List<WebElement> listProduct = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_TITLE_LIST_TEXT)));
		if (listProduct.size() <= Integer.parseInt(pageSize)) {
			return true;
		}
		return false;
	}

	public void clickToPageByNumber(String numberPage) {
		waitForElementClickable(driver, CategoriesSideBarPageUI.PAGE_LINK_BY_NUMBER, numberPage);
		clickToElement(driver, CategoriesSideBarPageUI.PAGE_LINK_BY_NUMBER, numberPage);
	}

	public boolean isPageActiveByNumber(String numberPage) {
		if (numberPage.equalsIgnoreCase("Current page")) {
			waitForElementVisible(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
			numberPage = getElementText(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
		}
		waitForElementVisible(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT_BY_NUMBER, numberPage);
		return isElementDisplayed(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT_BY_NUMBER, numberPage);
	}

	public void clickToProductByNameOnEachPage(List<WebElement> list, String nameProduct) {
		for (WebElement webElement : list) {
			if (webElement.getText().equals(nameProduct)) {
				webElement.click();
				backToPage(driver);
			}
			break;
		}
	}

	public void clickToAnyProduct(String nameProduct) {
		if (isElementUndisplayed(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT)) {
			List<WebElement> listProductNameOnEachPage = getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_TITLE_LIST_TEXT);
			clickToProductByNameOnEachPage(listProductNameOnEachPage, nameProduct);

		} else {
			String currentNumberPage = getElementText(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
			while (isNextPageButtonActived(currentNumberPage)) {
				System.out.println("Next page is actived.");
				sleepInSecond(4);
				waitForElementClickable(driver, CategoriesSideBarPageUI.NEXT_PAGE_BUTTON_BY_NAME, currentNumberPage);
				clickToElement(driver, CategoriesSideBarPageUI.NEXT_PAGE_BUTTON_BY_NAME, currentNumberPage);

				List<WebElement> listProductNameOnNextPage = getListWebElement(driver, CategoriesSideBarPageUI.PRODUCT_TITLE_LIST_TEXT);
				clickToProductByNameOnEachPage(listProductNameOnNextPage, nameProduct);
				currentNumberPage = getElementText(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
				System.out.println("currentNumberPage: " + currentNumberPage);
			}
		}
	}

	public boolean isPreviousPageButtonActived(String currentNumberPage) {
		if (currentNumberPage.equalsIgnoreCase("Current page")) {
			waitForElementVisible(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
			currentNumberPage = getElementText(driver, CategoriesSideBarPageUI.PAGE_LINK_CURRENT);
		}
		waitForElementVisible(driver, CategoriesSideBarPageUI.PREVIOUS_PAGE_BUTTON_BY_NAME, currentNumberPage);
		return isElementDisplayed(driver, CategoriesSideBarPageUI.PREVIOUS_PAGE_BUTTON_BY_NAME, currentNumberPage);
	}

	public boolean isPagingDeactivated() {
		return isElementUndisplayed(driver, CategoriesSideBarPageUI.PAGER_LINK);
	}
}
