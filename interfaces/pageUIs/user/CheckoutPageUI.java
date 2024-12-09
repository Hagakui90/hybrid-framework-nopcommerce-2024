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
}
