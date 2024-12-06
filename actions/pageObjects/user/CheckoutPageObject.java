package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage{
	WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkToShipToSameAddressCheckbox() {
		waitForElementClickable(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
		clickToElement(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
	}
	
	public void clickToBillingAddressDropdown(String value) {
		waitForElementClickable(driver, CheckoutPageUI.BILLING_ADDRESS_DROPDOWN);
		selectItemInDefaultDropdown(driver, CheckoutPageUI.BILLING_ADDRESS_DROPDOWN, value);
	}
	
	public void inputAddressToTextbox(String nameTextbox, String valueTextbox) {
		waitForElementVisible(driver, CheckoutPageUI.INFORMATION_ADDRESS_TEXTBOX_BY_NAME, nameTextbox);
		sendkeyToElement(driver, CheckoutPageUI.INFORMATION_ADDRESS_TEXTBOX_BY_NAME, valueTextbox, nameTextbox);
	}
	
	public void clickToAddressDropdown(String nameDropdown, String value) {
		waitForElementClickable(driver, CheckoutPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, CheckoutPageUI.COUNTRY_DROPDOWN, value);
	}
	
	public void inputNewAddressForm(String firstName, String lastName, String email, String country, String province, String city, String address1, String zipPostalCode, String phoneNumber) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FORM);
		inputAddressToTextbox("FirstName", firstName);
		inputAddressToTextbox("LastName", lastName);
		inputAddressToTextbox("Email", email);
		clickToAddressDropdown("BillingNewAddress_CountryId", country);
		clickToAddressDropdown("BillingNewAddress_StateProvinceId", province);
		inputAddressToTextbox("City", city);
		inputAddressToTextbox("Address1", address1);
		inputAddressToTextbox("ZipPostalCode", zipPostalCode);
		inputAddressToTextbox("PhoneNumber", phoneNumber);
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON);
		
	}
}
