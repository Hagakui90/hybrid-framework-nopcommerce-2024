package pageUIs.user;

public class CartPageUI {
	public static final String PRODUCT_NAME_IN_CART_TABLE = "xpath=//tr//a[text()=\"%s\"]";
	public static final String PRICE_PRODUCT_IN_CART_TABLE_BY_NAME = "xpath=//a[text()=\"%s\"]//ancestor::tr//span[@class='product-unit-price']";
}
