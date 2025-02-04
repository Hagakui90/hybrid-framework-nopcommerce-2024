package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.BuildYourOwnComputerPageUI;

public class BuildYourOwnComputerPageObject extends DetailProductPageObject{
	WebDriver driver;

	public BuildYourOwnComputerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void checkEveryRadioOrCheckBox(String label, String idAttribute, String dataAttributeValue) {
		waitForElementVisible(driver, BuildYourOwnComputerPageUI.CHECKBOX, label, idAttribute, dataAttributeValue);
		checkToElement(driver, BuildYourOwnComputerPageUI.CHECKBOX, label, idAttribute, dataAttributeValue);
	}
	public void uncheckEveryCheckBox(String label, String idAttribute, String dataAttributeValue) {
		waitForElementVisible(driver, BuildYourOwnComputerPageUI.CHECKBOX, label, idAttribute, dataAttributeValue);
		uncheckToElement(driver, BuildYourOwnComputerPageUI.CHECKBOX, label, idAttribute, dataAttributeValue);
	}
	
	public void buildOwnComputer() {
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.PROCESSOR_DROPDOWN);
		selectItemInDefaultDropdown(driver, BuildYourOwnComputerPageUI.PROCESSOR_DROPDOWN, "products.productattributes.priceadjustment");
		
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdown(driver, BuildYourOwnComputerPageUI.RAM_DROPDOWN, "products.productattributes.priceadjustment");

		checkEveryRadioOrCheckBox("HDD", "3", "7");
		checkEveryRadioOrCheckBox("OS", "4", "9");
		checkEveryRadioOrCheckBox("Software", "5", "10");
		checkEveryRadioOrCheckBox("Software", "5", "11");
		checkEveryRadioOrCheckBox("Software", "5", "12");
		
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, BuildYourOwnComputerPageUI.ADD_TO_CART_BUTTON);
		closeReviewNotiBar();
	}
	
	public String getTextNotificationBar() {
		waitForElementVisible(driver, BuildYourOwnComputerPageUI.NOTIFICATION_BAR);
		return getElementText(driver, BuildYourOwnComputerPageUI.NOTIFICATION_BAR);
	}
	
	public boolean verifyShoppingCart() {
		String quantityOfCart = getElementText(driver, BuildYourOwnComputerPageUI.QUANTITY_CART_TIP_TEXT);
		hoverToElement(driver, BuildYourOwnComputerPageUI.SHOPPING_CART_LINKTEXT);
		waitForElementInVisible(driver, BuildYourOwnComputerPageUI.MINI_SHOPPING_CART_FORM);
		removeAttributeInDOM(driver, BuildYourOwnComputerPageUI.MINI_SHOPPING_CART_FORM, "class");
		
		String productName = getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_NAME_IN_MINI_SHOPPING_CART);
		String attributesProduct = getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_ATTRIBUTES_IN_MINI_SHOPPING_CART);
		String subtotalProduct = getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_SUBTOTAL_IN_MINI_SHOPPING_CART);
		String quantityOfCartInMiniShoppingCart = getElementText(driver, BuildYourOwnComputerPageUI.QUANTITY_CART_TEXT_IN_MINI_SHOPPING_CART);
		
		if (quantityOfCart.equals("shoppingcart.headerquantity")) {
			if (productName.equals("Build your own computer") && quantityOfCartInMiniShoppingCart.equals("shoppingcart.mini.itemstext")) {
				if (attributesProduct.contains("2.5 GHz Intel Pentium Dual-Core E2200formattedattributes.priceadjustment")
						&& attributesProduct.contains("4GBformattedattributes.priceadjustment")
								&& attributesProduct.contains("400 GBformattedattributes.priceadjustment")
								&& attributesProduct.contains("Vista Premiumformattedattributes.priceadjustment")
								&& attributesProduct.contains("Microsoft Officeformattedattributes.priceadjustment")
								&& attributesProduct.contains("Acrobat Readerformattedattributes.priceadjustment")
								&& attributesProduct.contains("Total Commanderformattedattributes.priceadjustment")) {
					if(subtotalProduct.equals(getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_PRICE)))
						return true;
					
				}
			}
		}
		return false;
	}
	
	public void clickToViewCartButton() {
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.VIEW_CART_BUTTON);
		clickToElement(driver, BuildYourOwnComputerPageUI.VIEW_CART_BUTTON);
	}
	
	public boolean editProductInShoppingCart() {
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.PROCESSOR_DROPDOWN);
		selectItemInDefaultDropdown(driver, BuildYourOwnComputerPageUI.PROCESSOR_DROPDOWN, "2.2 GHz Intel Pentium Dual-Core E2200");
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdownByValue(driver, BuildYourOwnComputerPageUI.RAM_DROPDOWN, "4");
		checkEveryRadioOrCheckBox("HDD", "3", "6");
		checkEveryRadioOrCheckBox("OS", "4", "8");
		checkEveryRadioOrCheckBox("Software", "5", "10");
		sleepInSecond(5);
		uncheckEveryCheckBox("Software", "5", "11");
		uncheckEveryCheckBox("Software", "5", "12");
		if (getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_PRICE).equals("$1,320.00")) {
			waitForElementVisible(driver, BuildYourOwnComputerPageUI.QUANTITY_TEXTBOX);
			sendkeyToElement(driver, BuildYourOwnComputerPageUI.QUANTITY_TEXTBOX, "2");
			waitForElementClickable(driver, BuildYourOwnComputerPageUI.UPDATE_TO_CART_BUTTON);
			clickToElement(driver, BuildYourOwnComputerPageUI.UPDATE_TO_CART_BUTTON);
			return true;
		}
		return false;
	}
	
	public boolean verifyUpdatedShoppingCart() {
		closeReviewNotiBar();
		String quantityOfCart = getElementText(driver, BuildYourOwnComputerPageUI.QUANTITY_CART_TIP_TEXT);
		System.out.println(quantityOfCart);
		hoverToElement(driver, BuildYourOwnComputerPageUI.SHOPPING_CART_LINKTEXT);
		waitForElementInVisible(driver, BuildYourOwnComputerPageUI.MINI_SHOPPING_CART_FORM);
		removeAttributeInDOM(driver, BuildYourOwnComputerPageUI.MINI_SHOPPING_CART_FORM, "class");
		
		String productName = getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_NAME_IN_MINI_SHOPPING_CART);
		String attributesProduct = getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_ATTRIBUTES_IN_MINI_SHOPPING_CART);
		String subtotalProduct = getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_SUBTOTAL_IN_MINI_SHOPPING_CART);
		String quantityOfCartInMiniShoppingCart = getElementText(driver, BuildYourOwnComputerPageUI.QUANTITY_CART_TEXT_IN_MINI_SHOPPING_CART);
		
		System.out.println(productName);
		System.out.println(attributesProduct);
		System.out.println(subtotalProduct);
		System.out.println(quantityOfCartInMiniShoppingCart);
		System.out.println(getElementText(driver, BuildYourOwnComputerPageUI.PRODUCT_PRICE));
		
		if (quantityOfCart.equals("shoppingcart.headerquantity")) {
			if (productName.equals("Build your own computer") && quantityOfCartInMiniShoppingCart.equals("shoppingcart.mini.itemstext")) {
				if (attributesProduct.contains("2.2 GHz Intel Pentium Dual-Core E2200")
						&& attributesProduct.contains("4GBformattedattributes.priceadjustment")
								&& attributesProduct.contains("320 GB")
								&& attributesProduct.contains("Vista Homeformattedattributes.priceadjustment")
								&& attributesProduct.contains("Microsoft Officeformattedattributes.priceadjustment")) {
					if(subtotalProduct.equals("$2,640.00"))
						return true;
					
				}
			}
		}
		return false;
	}
	
}
