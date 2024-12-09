package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.BillingAddress;
import commons.ShippingAddress;
import pageUIs.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage{
	WebDriver driver;
	BillingAddress billingAddress;
	ShippingAddress shippingAddress;

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
	
	public String getInfoText(String infoName, String info) {
		waitForElementVisible(driver, CheckoutPageUI.INFO_TEXT_BY_NAME, infoName, info);
		return getElementText(driver, CheckoutPageUI.INFO_TEXT_BY_NAME, infoName, info);
	}
	
	public BillingAddress createBillingAddress(String firstName, String lastName, String email, String country, String province, String city, String address1, String zipPostalCode, String phoneNumber) {
		return new BillingAddress(firstName, lastName, email, country, province, city, address1, zipPostalCode, phoneNumber);
	}
	
	public ShippingAddress createShippingAddress(String firstName, String lastName, String email, String country, String province, String city, String address1, String zipPostalCode, String phoneNumber) {
		return new ShippingAddress(firstName, lastName, email, country, province, city, address1, zipPostalCode, phoneNumber);
	}
	
	public void inputBillingNewAddressForm(BillingAddress billingAddress) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-billing");
		uncheckToElement(driver, CheckoutPageUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
		inputAddressToTextbox("BillingNewAddress_FirstName", billingAddress.getFirstName());
		inputAddressToTextbox("BillingNewAddress_LastName", billingAddress.getLastName());
		inputAddressToTextbox("BillingNewAddress_Email", billingAddress.getEmail());
		clickToAddressDropdown("BillingNewAddress_CountryId", billingAddress.getCountry());
		clickToAddressDropdown("BillingNewAddress_StateProvinceId", billingAddress.getProvince());
		inputAddressToTextbox("BillingNewAddress_City", billingAddress.getCity());
		inputAddressToTextbox("BillingNewAddress_Address1", billingAddress.getAddress1());
		inputAddressToTextbox("BillingNewAddress_ZipPostalCode", billingAddress.getZipPostalCode());
		inputAddressToTextbox("BillingNewAddress_PhoneNumber", billingAddress.getPhoneNumber());
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "billing");
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "billing");
	}
	
	public void inputShippingNewAddressForm(ShippingAddress shippingAddress) {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-shipping");
		clickToAddressDropdownByType("shipping-address-select", "checkout.newaddress");
		inputAddressToTextbox("ShippingNewAddress_FirstName", shippingAddress.getFirstName());
		inputAddressToTextbox("ShippingNewAddress_LastName", shippingAddress.getLastName());
		inputAddressToTextbox("ShippingNewAddress_Email", shippingAddress.getEmail());
		clickToAddressDropdown("ShippingNewAddress_CountryId", shippingAddress.getAddress1());
		clickToAddressDropdown("ShippingNewAddress_StateProvinceId", shippingAddress.getProvince());
		inputAddressToTextbox("ShippingNewAddress_City", shippingAddress.getCity());
		inputAddressToTextbox("ShippingNewAddress_Address1", shippingAddress.getAddress1());
		inputAddressToTextbox("ShippingNewAddress_ZipPostalCode", shippingAddress.getZipPostalCode());
		inputAddressToTextbox("ShippingNewAddress_PhoneNumber", shippingAddress.getPhoneNumber());
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "shipping");
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_TYPE, "shipping");
	}
	
	public boolean verifyInforAddress(BillingAddress billingAddress, ShippingAddress shippingAddress) {
		boolean verifyBillingAddress = false;
		boolean verifyShippingAddress = false;
		if (getInfoText("billing-info", "name").equals(billingAddress.getFirstName() + billingAddress.getLastName())) {
			if (getInfoText("billing-info", "email").contains(billingAddress.getEmail()) && getInfoText("billing-info", "phone").contains(billingAddress.getPhoneNumber())) {
					if (getInfoText("billing-info", "country").contains(billingAddress.getCountry()) && getInfoText("billing-info", "stateprovince").contains(billingAddress.getProvince()) && getInfoText("billing-info", "city").contains(billingAddress.getCity())) {
						if (getInfoText("billing-info", "address1").contains(billingAddress.getAddress1()) && getInfoText("billing-info", "zippostalcode").contains(billingAddress.getZipPostalCode())) {
							return verifyBillingAddress = true;
						}
					}
				}
			}
		
		if (getInfoText("shipping-info", "name").equals(shippingAddress.getFirstName() + shippingAddress.getLastName())) {
			if (getInfoText("shipping-info", "email").contains(shippingAddress.getEmail()) && getInfoText("shipping-shipping", "phone").contains(shippingAddress.getPhoneNumber())) {
					if (getInfoText("shipping-info", "country").contains(shippingAddress.getCountry()) && getInfoText("shipping-info", "stateprovince").contains(shippingAddress.getProvince()) && getInfoText("shipping-info", "city").contains(shippingAddress.getCity())) {
						if (getInfoText("shipping-info", "address1").contains(shippingAddress.getAddress1()) && getInfoText("shipping-info", "zippostalcode").contains(shippingAddress.getZipPostalCode())) {
							return verifyShippingAddress = true;
						}
					}
				}
			}
		if (verifyBillingAddress && verifyShippingAddress) {
			return true;
		}
		return false;
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
	
	public boolean verifySelectedShippingMethod(String shippingMethod) {
		
		return false;
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
	
	public boolean verifyConfirmedOrder() {
		waitForElementVisible(driver, CheckoutPageUI.ENTER_ADDRESS_FOR_BY_TYPE, "checkout-step-confirm-order");
		boolean verifyInforAddress = verifyInforAddress(billingAddress, shippingAddress);
		return true;
	}
}
