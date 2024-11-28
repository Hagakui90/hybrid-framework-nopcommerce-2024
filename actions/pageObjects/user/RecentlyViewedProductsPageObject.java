package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.Product;
import pageUIs.user.RecentlyViewedProductsPageUI;

public class RecentlyViewedProductsPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;

	public RecentlyViewedProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean verifyProductsInRecentlyViewed(Product product) {
		List<WebElement> listProductName = getListWebElement(driver, RecentlyViewedProductsPageUI.LIST_PRODUCT_NAME);
		for (WebElement productName : listProductName) {
			if (productName.getText().equals(product.getTitleOfProduct())) {
				if (getElementText(driver, RecentlyViewedProductsPageUI.PRODUCT_PRICE_BY_NAME, productName.getText()).equals(product.getPriceOfProduct())) {
					return true;
				}else return false;
			}
		}
		return false;
	}
}
