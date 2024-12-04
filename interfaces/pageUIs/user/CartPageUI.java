package pageUIs.user;

public class CartPageUI {
	public static final String PRODUCT_NAME_IN_CART_TABLE = "xpath=//tr//a[text()=\"%s\"]";
	public static final String PRICE_PRODUCT_IN_CART_TABLE_BY_NAME = "xpath=//a[text()=\"%s\"]//ancestor::tr//span[@class='product-unit-price']";
	public static final String LIST_REMOVE_BUTTON = "CSS=button.remove-btn";
	public static final String EDIT_BUTTON = "xpath=//a[text()='common.edit']";
}
