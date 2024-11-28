package pageUIs.user;

public class CompareProductsPageUI {
	public static final String COLUMN_INDEX_BY_NAME_PRODUCT = "XPATH=//a[text()='%s']//parent::td//preceding-sibling::td";
	public static final String PRODUCT_PRICE_BY_COLUMN_INDEX = "XPATH=//tr[@class='product-price']//td[%s]";
	public static final String REMOVE_BUTTON_BY_COLUMN_INDEX = "XPATH=//tr[@class='remove-product']//td[%s]/button";
	public static final String LIST_PRODUCT_NAME = "xpath=//tr[@class='product-name']//td//a";
	public static final String CLEAR_LIST_BUTTON = "CSS=a.clear-list";
	public static final String NOTIFY_DATA_TEXT = "CSS=div.no-data";
}
