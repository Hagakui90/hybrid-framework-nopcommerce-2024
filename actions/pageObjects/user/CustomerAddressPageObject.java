package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerAddressPageUI;

public class CustomerAddressPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public CustomerAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void openAddressForm() {
		waitForElementClickable(driver, CustomerAddressPageUI.ADD_BUTTON);
		clickToElement(driver, CustomerAddressPageUI.ADD_BUTTON);
	}
	
	public void inputAddressForm(String firstName, String lastName, String email, String company, String country, String state,
			String city, String address1, String address2, String zipPostalCode, String phoneNumber, String faxNumber) {
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.firstname");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, firstName, "address.fields.firstname");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.lastname");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, lastName, "address.fields.lastname");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.email");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, email, "address.fields.email");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.company");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, company, "address.fields.company");
		
		waitForElementClickable(driver, CustomerAddressPageUI.INFO_ADDRESS_DROPDOWN, "address.fields.country");
		selectItemInDefaultDropdown(driver, CustomerAddressPageUI.INFO_ADDRESS_DROPDOWN, country, "address.fields.country");
		
		waitForElementClickable(driver, CustomerAddressPageUI.INFO_ADDRESS_DROPDOWN, "address.fields.stateprovince");
		selectItemInDefaultDropdown(driver, CustomerAddressPageUI.INFO_ADDRESS_DROPDOWN, state, "address.fields.stateprovince");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.city");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, city, "address.fields.city");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.address1");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, address1, "address.fields.address1");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.address2");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, address2, "address.fields.address2");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.zippostalcode");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, zipPostalCode, "address.fields.zippostalcode");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.phonenumber");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, phoneNumber, "address.fields.phonenumber");
		
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, "address.fields.faxnumber");
		sendkeyToElement(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, faxNumber, "address.fields.faxnumber");
		
		waitForElementClickable(driver, CustomerAddressPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerAddressPageUI.SAVE_BUTTON);
	}
	
	public String getAddedNotificationBarText() {
		waitForElementVisible(driver, CustomerAddressPageUI.ADDED_NOTIFICATION_BAR);
		return getElementText(driver, CustomerAddressPageUI.ADDED_NOTIFICATION_BAR);
	}
	
	public String getAddedInfoText(String indexOfAddedAddress, String info) {
		waitForElementVisible(driver, CustomerAddressPageUI.NEW_ADDED_INFO_SECTION, indexOfAddedAddress, info);
		return getElementText(driver, CustomerAddressPageUI.NEW_ADDED_INFO_SECTION, indexOfAddedAddress, info);
	}
	
	public int numberOfListAddress() {
		waitForElementVisible(driver, CustomerAddressPageUI.ADDRESS_ITEM_LIST);
		int getListAddressItem = getListElementSize(driver, CustomerAddressPageUI.ADDRESS_ITEM_LIST);
		return getListAddressItem;
	}
	
}
