package pageObjects.user;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public void removeAllProductFromCart() {
		List<WebElement> listRemoveButton = getListWebElement(driver, CartPageUI.LIST_REMOVE_BUTTON);
		if (listRemoveButton.size() != 0) {
			for (WebElement button : listRemoveButton) {
				System.out.println("Remove");
				button.click();
			}
		}
		
	}

	public void clickToEditButton() {
		waitForElementClickable(driver, CartPageUI.EDIT_BUTTON);
		clickToElement(driver, CartPageUI.EDIT_BUTTON);
	}
	
	public String getCartStatusText() {
		waitForElementVisible(driver, CartPageUI.CART_STATUS_TEXT);
		return getElementText(driver, CartPageUI.CART_STATUS_TEXT);
	}
	
	public void searchProduct(String keyword) {
		waitForElementVisible(driver, CartPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, CartPageUI.SEARCH_TEXTBOX, keyword);
		
		waitForElementClickable(driver, CartPageUI.SEARCH_BUTTON);
		clickToElement(driver, CartPageUI.SEARCH_BUTTON);
	}
	
	public void updateQuantity(String productName, String quantity) {
		waitForElementVisible(driver, CartPageUI.QUANTITY_PRODUCT_TEXTBOX_IN_CART_TABLE_BY_NAME, productName);
		sendkeyToElementByJS(driver, CartPageUI.QUANTITY_PRODUCT_TEXTBOX_IN_CART_TABLE_BY_NAME, quantity, productName);
		sendKeyboardToElement(driver, CartPageUI.QUANTITY_PRODUCT_TEXTBOX_IN_CART_TABLE_BY_NAME,  Keys.ENTER, productName);
	}
	
	public String getTotalPriceByProductName(String productName) {
		waitForElementVisible(driver, CartPageUI.TOTAL_PRICE_PRODUCT_IN_CART_TABLE_BY_NAME, productName);
		return getElementText(driver, CartPageUI.TOTAL_PRICE_PRODUCT_IN_CART_TABLE_BY_NAME, productName);
	}
	
	public void selectGiftWrapping(String value) {
		waitForElementClickable(driver, CartPageUI.GIFT_WRAPPING_DROPDOWN);
		selectItemInDefaultDropdown(driver, CartPageUI.GIFT_WRAPPING_DROPDOWN, value);
	}
	
	public String getGiftWrappingLabel() {
		waitForElementVisible(driver, CartPageUI.GIFT_WRAPPING_LABEL);
		return getElementText(driver, CartPageUI.GIFT_WRAPPING_LABEL);
	}
	
	public String getItemTotalText(String itemTotal) {
		waitForElementVisible(driver, CartPageUI.CART_TOTAL_TEXT_BY_NAME, itemTotal);
		return getElementText(driver, CartPageUI.CART_TOTAL_TEXT_BY_NAME, itemTotal);
	}
	
	public void inputToEstimateShippingPopup(String countryAddress, String provinceAddress, String zipPostalCode, String shippingMethod) {
		waitForElementClickable(driver, CartPageUI.ESTIMATE_SHIPPING_BUTTON);
		clickToElement(driver, CartPageUI.ESTIMATE_SHIPPING_BUTTON);
		waitForElementVisible(driver, CartPageUI.ESTIMATE_SHIPPING_POPUP);
		selectItemInDefaultDropdown(driver, CartPageUI.ADDRESS_SHIPPING_DROPDOWN, countryAddress, "CountryId");
		waitForElementVisible(driver, CartPageUI.ADDRESS_SHIPPING_DROPDOWN, "StateProvinceId");
		selectItemInDefaultDropdown(driver, CartPageUI.ADDRESS_SHIPPING_DROPDOWN, provinceAddress, "StateProvinceId");
		waitForElementVisible(driver, CartPageUI.ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, CartPageUI.ZIP_POSTAL_CODE_TEXTBOX, zipPostalCode);
		waitForElementVisible(driver, CartPageUI.SHIPPING_METHOD_RADIO_BUTTON_BY_NAME, shippingMethod);
		checkToElement(driver, CartPageUI.SHIPPING_METHOD_RADIO_BUTTON_BY_NAME, shippingMethod);
		waitForElementClickable(driver, CartPageUI.APPLY_SHIPPING_BUTTON);
		clickToElement(driver, CartPageUI.APPLY_SHIPPING_BUTTON);
	}
	
	
}
