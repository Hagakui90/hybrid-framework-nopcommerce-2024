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

public class CategoiesSideBarPageObject extends BasePage{
	WebDriver driver;
	public CategoiesSideBarPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void openCategoriesSideBarPage(String categoryName, String subCategoryName) {
		waitForElementClickable(driver, CategoriesSideBarPageUI.DYNAMIC_SUBMENU_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
		clickToElement(driver, CategoriesSideBarPageUI.DYNAMIC_SUBMENU_SIDEBAR_LINK_TEXT, categoryName, subCategoryName);
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
}
