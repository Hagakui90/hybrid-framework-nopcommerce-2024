package pageUIs.user;

public class CheckoutPageUI {
	public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "CSS=div.ship-to-same-address input";
	public static final String ADDRESS_DROPDOWN_BY_TYPE = "CSS=select#%s";
	public static final String ENTER_ADDRESS_FOR_BY_TYPE = "CSS=div#%s";
	public static final String INFORMATION_ADDRESS_TEXTBOX_BY_NAME = "XPATH=//input[contains(@id,'%s')]";
	public static final String DROPDOWN_BY_NAME = "css=select#%s";
	public static final String CONTINUE_BUTTON_BY_TYPE = "xpath=//div[@id='%s-buttons-container']//button[contains(text(),'continue')]";
	public static final String SHIPPING_METHOD_RADIO_BUTTON_BY_NAME = "xpath=//div[contains(text(),'%s')]//preceding-sibling::div/input";
	public static final String PAYMENT_RADIO_BUTTON_BY_NAME = "xpath=//label[contains(text(),'%s')]//preceding-sibling::input";
	public static final String PAYMENT_INFO_AREA = "css=div.payment-info";
	public static final String INFO_TEXT_BY_NAME = "css=div.%s li.%s";
	public static final String INFO_METHOD_TEXT_BY_NAME = "CSS=li.%s span.value";
	public static final String PRODUCT_INFO_TEXT = "CSS=table.cart tbody tr";
	public static final String PRODUCT_INFO_ITEM_TEXT_BY_NAME = "CSS=table.cart td.%s span";
	public static final String NAME_INFO_TEXT = "CSS=table.cart td.product a";
	public static final String CART_OPTION_TEXT = "CSS=div.cart-options";
	public static final String CART_FOOTER_TEXT = "CSS=div.cart-footer";
	public static final String CART_FOOTER_ITEM_TEXT_BY_NAME = "CSS=div.cart-footer tr.%s td.cart-total-right span";
	public static final String ORDER_TOTAL_TEXT = "CSS=div.cart-footer tr.order-total td.cart-total-right strong";
}
