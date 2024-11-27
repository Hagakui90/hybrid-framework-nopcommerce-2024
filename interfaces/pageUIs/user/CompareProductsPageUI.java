package pageUIs.user;

public class CompareProductsPageUI {
	public static final String PRODUCT_NAME_IN_COMPARE_TABLE = "xpath=//a[text()='%s']";
	public static final String COLUMN_INDEX_BY_NAME_PRODUCT = "XPATH=//a[text()='%s']//parent::td//preceding-sibling::td";
	public static final String PRODUCT_PRICE_BY_COLUMN_INDEX = "XPATH=//tr[@class='product-price']//td[%s]";
}
