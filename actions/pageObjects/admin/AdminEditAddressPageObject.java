package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.Address;
import commons.BasePage;
import pageUIs.admin.AdminEditAddressPageUI;

public class AdminEditAddressPageObject extends BasePage{
	WebDriver driver;

	public AdminEditAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputTextToInfoTextboxByName(String nameInfo, String value) {
		waitForElementVisible(driver, AdminEditAddressPageUI.INFO_TEXTBOX_BY_NAME, nameInfo);
		sendkeyToElement(driver, AdminEditAddressPageUI.INFO_TEXTBOX_BY_NAME, value, nameInfo);
	}
	
	public void selectDropdownInfoByName(String nameInfo, String value) {
		waitForElementClickable(driver, AdminEditAddressPageUI.INFO_DROPDOWN_BY_NAME, nameInfo);
		selectItemInDefaultDropdown(driver, AdminEditAddressPageUI.INFO_DROPDOWN_BY_NAME, value, nameInfo);
	}
	public void inputFormEditAddress(Address address) {
		inputTextToInfoTextboxByName("FirstName", address.getFirstName());
		inputTextToInfoTextboxByName("LastName", address.getLastName());
		inputTextToInfoTextboxByName("Email", address.getEmail());
		inputTextToInfoTextboxByName("Company", address.getCompany());
		selectDropdownInfoByName("CountryId", address.getCountry());
		selectDropdownInfoByName("StateProvinceId", address.getProvince());
		inputTextToInfoTextboxByName("County", address.getCounty());
		inputTextToInfoTextboxByName("City", address.getCity());
		inputTextToInfoTextboxByName("Address1", address.getAddress1());
		inputTextToInfoTextboxByName("Address2", address.getAddress2());
		inputTextToInfoTextboxByName("ZipPostalCode", address.getZipPostalCode());
		inputTextToInfoTextboxByName("PhoneNumber", address.getPhoneNumber());
		inputTextToInfoTextboxByName("FaxNumber", address.getFaxNumber());
		waitForElementClickable(driver, AdminEditAddressPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminEditAddressPageUI.SAVE_BUTTON);
	}
	public String getAlertSuccessMessage() {
		waitForElementVisible(driver, AdminEditAddressPageUI.ALERT_SUCCESS_MESSAGE);
		return getElementText(driver, AdminEditAddressPageUI.ALERT_SUCCESS_MESSAGE);
	}
	
	public String getValueAttributeInfo(String nameInfo) {
		if (nameInfo.equals("CountryId") || nameInfo.equals("StateProvinceId")) {
			waitForElementVisible(driver, AdminEditAddressPageUI.INFO_DROPDOWN_BY_NAME, nameInfo);
			return getFirstSelectedTextInDefaultDropdown(driver, AdminEditAddressPageUI.INFO_DROPDOWN_BY_NAME, nameInfo);
		} else {
			waitForElementVisible(driver, AdminEditAddressPageUI.INFO_TEXTBOX_BY_NAME, nameInfo);
			return getElementAttribute(driver, AdminEditAddressPageUI.INFO_TEXTBOX_BY_NAME, "value", nameInfo);
		}
	}
	
	public boolean verifyEditedAddress(Address address) {
		boolean verifyFirstName = getValueAttributeInfo("FirstName").equals(address.getFirstName());
		boolean verifyLastName = getValueAttributeInfo("LastName").equals(address.getLastName());
		boolean verifyEmail = getValueAttributeInfo("Email").equals(address.getEmail());
		boolean verifyCompany = getValueAttributeInfo("Company").equals(address.getCompany());
		boolean verifyCountry = getValueAttributeInfo("CountryId").equals(address.getCountry());
		boolean verifyStateProvince = getValueAttributeInfo("StateProvinceId").equals(address.getProvince());
		boolean verifyCity = getValueAttributeInfo("City").equals(address.getCity());
		boolean verifyAddress1 = getValueAttributeInfo("Address1").equals(address.getAddress1());
		boolean verifyAddress2 = getValueAttributeInfo("Address2").equals(address.getAddress2());
		boolean verifyZipPostalCode = getValueAttributeInfo("ZipPostalCode").equals(address.getZipPostalCode());
		boolean verifyPhoneNumber = getValueAttributeInfo("PhoneNumber").equals(address.getPhoneNumber());
		boolean verifyFaxNumber = getValueAttributeInfo("FaxNumber").equals(address.getFaxNumber());

		return verifyFirstName && verifyLastName && verifyEmail && verifyCompany && verifyCountry && verifyStateProvince &&
				verifyCity && verifyAddress1 && verifyAddress2 && verifyZipPostalCode && verifyPhoneNumber && verifyFaxNumber;
	}
	
	public void backToCustomerList() {
		waitForElementClickable(driver, AdminEditAddressPageUI.BACK_TO_CUSTOMER_BUTTON);
		clickToElement(driver, AdminEditAddressPageUI.BACK_TO_CUSTOMER_BUTTON);
	}
}
