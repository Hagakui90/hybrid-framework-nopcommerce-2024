package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	WebDriver driver;
	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyAddedProductInWishlist(String nameProduct, String priceProduct){
		
		if (isElementUndisplayed(driver, WishlistPageUI.PRODUCT_NAME_IN_WISHLIST_TABLE, nameProduct)) {
			return false;
		}
		else {
			waitForElementVisible(driver, WishlistPageUI.PRICE_NAME_IN_WISHLIST_TABLE_BY_NAME, nameProduct);
			if (getElementText(driver, WishlistPageUI.PRICE_NAME_IN_WISHLIST_TABLE_BY_NAME, nameProduct).equals(priceProduct)) {
				return true;
			}else return false;
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
}
