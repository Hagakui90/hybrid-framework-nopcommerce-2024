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
	
	public void clickToAddressDropdownByType(String typeAddress, String value) {
		waitForElementClickable(driver, CheckoutPageUI.ADDRESS_DROPDOWN_BY_TYPE, typeAddress);
		selectItemInDefaultDropdown(driver, CheckoutPageUI.ADDRESS_DROPDOWN_BY_TYPE, value, typeAddress);
	}
	
	public void inputAddressToTextbox(String nameTextbox, String valueTextbox) {
		waitForElementVisible(driver, CheckoutPageUI.INFORMATION_ADDRESS_TEXTBOX_BY_NAME, nameTextbox);
		sendkeyToElement(driver, CheckoutPageUI.INFORMATION_ADDRESS_TEXTBOX_BY_NAME, valueTextbox, nameTextbox);
	}
	
	public void clickToAddressDropdown(String nameDropdown, String value) {
		waitForElementClickable(driver, CheckoutPageUI.DROPDOWN_BY_NAME, nameDropdown);
		selectItemInDefaultDropdown(driver, CheckoutPageUI.DROPDOWN_BY_NAME, value, nameDropdown);
	}
	
	public void inputBillingNewAddressForm(String firstName, String lastName, String email, String country, String province, String city, String address1, String zipPostalCode, String phoneNumber) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-billing");
		uncheckToElement(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
		inputAddressToTextbox("BillingNewAddress_FirstName", firstName);
		inputAddressToTextbox("BillingNewAddress_LastName", lastName);
		inputAddressToTextbox("BillingNewAddress_Email", email);
		clickToAddressDropdown("BillingNewAddress_CountryId", country);
		clickToAddressDropdown("BillingNewAddress_StateProvinceId", province);
		inputAddressToTextbox("BillingNewAddress_City", city);
		inputAddressToTextbox("BillingNewAddress_Address1", address1);
		inputAddressToTextbox("BillingNewAddress_ZipPostalCode", zipPostalCode);
		inputAddressToTextbox("BillingNewAddress_PhoneNumber", phoneNumber);
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "billing");
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "billing");
	}
	
	public void inputShippingNewAddressForm(String firstName, String lastName, String email, String country, String province, String city, String address1, String zipPostalCode, String phoneNumber) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-shipping");
		clickToAddressDropdownByType("shipping-address-select", "checkout.newaddress");
		inputAddressToTextbox("ShippingNewAddress_FirstName", firstName);
		inputAddressToTextbox("ShippingNewAddress_LastName", lastName);
		inputAddressToTextbox("ShippingNewAddress_Email", email);
		clickToAddressDropdown("ShippingNewAddress_CountryId", country);
		clickToAddressDropdown("ShippingNewAddress_StateProvinceId", province);
		inputAddressToTextbox("ShippingNewAddress_City", city);
		inputAddressToTextbox("ShippingNewAddress_Address1", address1);
		inputAddressToTextbox("ShippingNewAddress_ZipPostalCode", zipPostalCode);
		inputAddressToTextbox("ShippingNewAddress_PhoneNumber", phoneNumber);
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "shipping");
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "shipping");
	}
	
	public void selectShippingMethod(String shippingMethod) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-shipping-method");
		waitForElementVisible(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON_BY_NAME, shippingMethod);
		checkToElement(driver, CheckoutPageUI.SHIPPING_METHOD_RADIO_BUTTON_BY_NAME, shippingMethod);
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "shipping-method");
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "shipping-method");
	}
	
	public void selectPaymentMethod(String paymentMethod) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-payment-method");
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_RADIO_BUTTON_BY_NAME, paymentMethod);
		checkToElement(driver, CheckoutPageUI.PAYMENT_RADIO_BUTTON_BY_NAME, paymentMethod);
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "'payment-method");
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "'payment-method");
	}
	
	public boolean verifySelectedPaymentMethod(String paymentMethod) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-payment-info");
		waitForElementVisible(driver, CheckoutPageUI.PAYMENT_INFO_AREA);
		String paymentInfo = getElementText(driver, CheckoutPageUI.PAYMENT_INFO_AREA);
		//"Check / Money Order"
		String[] handledPaymentMethod = paymentMethod.split(" / ");
		for (String string : handledPaymentMethod) {
			string.toLowerCase();
			if (paymentInfo.contains(string)) {
				return true;
			}
		} 
		return false;
	}
}
