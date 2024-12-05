package pageUIs.user;

public class CartPageUI {
	public static final String PRODUCT_NAME_IN_CART_TABLE = "xpath=//tr//a[text()=\"%s\"]";
	public static final String PRICE_PRODUCT_IN_CART_TABLE_BY_NAME = "xpath=//a[text()=\"%s\"]//ancestor::tr//span[@class='product-unit-price']";
	public static final String TOTAL_PRICE_PRODUCT_IN_CART_TABLE_BY_NAME = "xpath=//a[text()='%s']//ancestor::tr//span[@class='product-subtotal']";
	public static final String QUANTITY_PRODUCT_TEXTBOX_IN_CART_TABLE_BY_NAME = "xpath=//a[text()='%s']//ancestor::tr//input[@class='qty-input']";
	public static final String LIST_REMOVE_BUTTON = "CSS=button.remove-btn";
	public static final String EDIT_BUTTON = "xpath=//a[text()='common.edit']";
	public static final String CART_STATUS_TEXT = "CSS=div.order-summary-content div";
	public static final String SEARCH_BUTTON = "css=button.search-box-button";
	public static final String SEARCH_TEXTBOX = "css=input.search-box-text";
	public static final String CONTINUE_SHOPPING_BUTTON = "CSS=button.continue-shopping-button";
}
