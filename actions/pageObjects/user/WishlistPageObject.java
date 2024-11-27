package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyAddedProductInWishlist(String nameProduct, String priceProduct) {
		if (isElementDisplayed(driver, WishlistPageUI.PRODUCT_NAME_IN_WISHLIST_TABLE, nameProduct)) {
			waitForElementVisible(driver, WishlistPageUI.PRICE_PRODUCT_IN_WISHLIST_TABLE_BY_NAME, nameProduct);
			System.out.println("Price Product: " + getElementText(driver, WishlistPageUI.PRICE_PRODUCT_IN_WISHLIST_TABLE_BY_NAME, nameProduct));
			if (getElementText(driver, WishlistPageUI.PRICE_PRODUCT_IN_WISHLIST_TABLE_BY_NAME, nameProduct).equals(priceProduct)) {
				return true;
			} else
				return false;

		} else {
			System.out.println("Product is not added.");
			return false;

		}
	}

	public void clickToSharingLink() {
		waitForElementVisible(driver, WishlistPageUI.WISHLIST_LINKTEXT);
		clickToElement(driver, WishlistPageUI.WISHLIST_LINKTEXT);
	}

	public String getTitleLinkSharing() {
		waitForElementVisible(driver, WishlistPageUI.TITLE_SHARING_LINK);
		return getElementText(driver, WishlistPageUI.TITLE_SHARING_LINK);
	}

	public void addToCart(String nameProduct) {
		waitForElementVisible(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX, nameProduct);
		checkToElement(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX, nameProduct);

		waitForElementClickable(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CART_BUTTON);
	}

	public void clickToLogoLink() {
		waitForElementVisible(driver, WishlistPageUI.LOGO_LINK_TEXT);
		clickToElement(driver, WishlistPageUI.LOGO_LINK_TEXT);
	}

	public void clickToRemoveProduct(String nameProduct) {
		waitForElementClickable(driver, WishlistPageUI.REMOVE_PRODUCT_IN_WISHLIST_TABLE_BY_NAME, nameProduct);
		clickToElement(driver, WishlistPageUI.REMOVE_PRODUCT_IN_WISHLIST_TABLE_BY_NAME, nameProduct);
	}

	public boolean verifyRemovedProductInWishlist(String nameProduct) {
		if (isElementUndisplayed(driver, WishlistPageUI.PRODUCT_NAME_IN_WISHLIST_TABLE, nameProduct)) {
			return true;
		} else
			return false;
	}
}
