package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CartPageUI;

public class CartPageObject extends BasePage {
	WebDriver driver;

	public CartPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyAddedProductInCart(String nameProduct, String priceProduct) {

		if (isElementUndisplayed(driver, CartPageUI.PRODUCT_NAME_IN_CART_TABLE, nameProduct)) {
			return false;
		} else {
			waitForElementVisible(driver, CartPageUI.PRODUCT_NAME_IN_CART_TABLE, nameProduct);
			if (getElementText(driver, CartPageUI.PRICE_PRODUCT_IN_CART_TABLE_BY_NAME, nameProduct).equals(priceProduct)) {
				return true;
			} else
				return false;
		}
	}

	
}
