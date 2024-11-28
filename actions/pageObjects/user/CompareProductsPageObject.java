package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.Product;
import pageUIs.user.CompareProductsPageUI;



public class CompareProductsPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;

	public CompareProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean verifyAddedAnyProductInComparableTable(Product product) {
		List<WebElement> listProductName = getListWebElement(driver, CompareProductsPageUI.LIST_PRODUCT_NAME);
		for (int i = 0; i < listProductName.size(); i++) {
			if (listProductName.get(i).getText().equals(product.getTitleOfProduct())) {
				int columnIndex = getListElementSize(driver, CompareProductsPageUI.COLUMN_INDEX_BY_NAME_PRODUCT, product.getTitleOfProduct()) + 1;
				if (getElementText(driver, CompareProductsPageUI.PRODUCT_PRICE_BY_COLUMN_INDEX, String.valueOf(columnIndex)).equals(product.getPriceOfProduct())
						&& isElementDisplayed(driver, CompareProductsPageUI.REMOVE_BUTTON_BY_COLUMN_INDEX, String.valueOf(columnIndex))) {
					return true;
				} else return false;
			}
		}
		return false;
	}
	
	public boolean verifyAddedProductsInComparableTable(Product product_1, Product product_2) {
		if (verifyAddedAnyProductInComparableTable(product_1) && verifyAddedAnyProductInComparableTable(product_2)) {
			return true;
		}else return false;
	}
	
	public void clearListAddedProducts() {
		waitForElementClickable(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
		clickToElement(driver, CompareProductsPageUI.CLEAR_LIST_BUTTON);
	}
	
	public String getNotifyDataAfterClearList() {
		waitForElementVisible(driver, CompareProductsPageUI.NOTIFY_DATA_TEXT);
		return getElementText(driver, CompareProductsPageUI.NOTIFY_DATA_TEXT);
	}
	
}
