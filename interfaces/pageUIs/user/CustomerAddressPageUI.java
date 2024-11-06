package pageUIs.user;

public class CustomerAddressPageUI {
	public static final String ADD_BUTTON = "css=div.add-button";
	public static final String INFO_ADDRESS_TEXTBOX = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	public static final String INFO_ADDRESS_DROPDOWN = "xpath=//label[contains(text(),'%s')]/following-sibling::select";
	public static final String SAVE_BUTTON = "CSS=button.save-address-button";
	public final static String ADDED_NOTIFICATION_BAR = "CSS=div.bar-notification";
	public final static String ADDED_INFO_SECTION = "CSS=li.%s";
	public final static String ADDRESS_ITEM_LIST = "CSS=div.address-item";
	public final static String NEW_ADDED_INFO_SECTION = "xpath=//div[@class='address-list']//div[%s]//li[@class='%s']";
}
