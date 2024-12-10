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
	public static final String GIFT_WRAPPING_DROPDOWN = "xpath=//label[contains(text(),' Gift wrapping')]/parent::dt//following-sibling::dd//select";
	public static final String GIFT_WRAPPING_LABEL = "XPATH=//div[contains(text(),' Gift wrapping')]";
	public static final String ESTIMATE_SHIPPING_BUTTON = "css=a.estimate-shipping-button";
	public static final String ESTIMATE_SHIPPING_POPUP = "CSS=div.mfp-content";
	public static final String ADDRESS_SHIPPING_DROPDOWN = "CSS=select#%s";
	public static final String ZIP_POSTAL_CODE_TEXTBOX = "CSS=input#ZipPostalCode";
	public static final String SHIPPING_METHOD_RADIO_BUTTON_BY_NAME = "XPATH=//div[text()='%s']//preceding-sibling::div//label";
	public static final String APPLY_SHIPPING_BUTTON = "CSS=button.apply-shipping-button";
	public static final String CART_TOTAL_TEXT_BY_NAME = "XPATH=//label[contains(text(),'%s')]//ancestor::tr//span[@class='value-summary']";
	public static final String TERM_OF_SERVICE_CHECKBOX =  "css=input#termsofservice";
	public static final String CHECKOUT_BUTTON =  "css=button#checkout";
}
