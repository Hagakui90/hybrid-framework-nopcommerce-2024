package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.Address;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminAddNewAddressesPageUI;
import pageUIs.admin.AdminCustomersCustomersPageUI;

public class AdminAddNewAddressesPageObject extends BasePage{
	WebDriver driver;

	public AdminAddNewAddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputTextToInfoTextboxByName(String nameInfo, String value) {
		waitForElementVisible(driver, AdminAddNewAddressesPageUI.INFO_TEXTBOX_BY_NAME, nameInfo);
		sendkeyToElement(driver, AdminAddNewAddressesPageUI.INFO_TEXTBOX_BY_NAME, value, nameInfo);
	}
	
	public void selectDropdownInfoByName(String nameInfo, String value) {
		waitForElementClickable(driver, AdminAddNewAddressesPageUI.INFO_DROPDOWN_BY_NAME, nameInfo);
		selectItemInDefaultDropdown(driver, AdminAddNewAddressesPageUI.INFO_DROPDOWN_BY_NAME, value, nameInfo);
	}
	
	public void inputFormAddNewAddress(Address address) {
		inputTextToInfoTextboxByName("FirstName", address.getFirstName());
		inputTextToInfoTextboxByName("LastName", address.getLastName());
		inputTextToInfoTextboxByName("Email", address.getEmail());
		inputTextToInfoTextboxByName("Company", address.getCompany());
		selectDropdownInfoByName("CountryId", address.getCountry());
		selectDropdownInfoByName("StateProvinceId", address.getProvince());
		inputTextToInfoTextboxByName("County", "");
		inputTextToInfoTextboxByName("City", address.getCity());
		inputTextToInfoTextboxByName("Address1", address.getAddress1());
		inputTextToInfoTextboxByName("Address2", address.getAddress2());
		inputTextToInfoTextboxByName("ZipPostalCode", address.getZipPostalCode());
		inputTextToInfoTextboxByName("PhoneNumber", address.getPhoneNumber());
		inputTextToInfoTextboxByName("FaxNumber", address.getFaxNumber());
		waitForElementClickable(driver, AdminAddNewAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminAddNewAddressesPageUI.SAVE_BUTTON);
	}
	
	public String getAlertSuccessMessage() {
		waitForElementVisible(driver, AdminCustomersCustomersPageUI.ALERT_SUCCESS_MESSAGE);
		return getElementText(driver, AdminCustomersCustomersPageUI.ALERT_SUCCESS_MESSAGE);
	}
	
	public String getValueAttributeInfo(String nameInfo) {
		if (nameInfo.equals("CountryId") || nameInfo.equals("StateProvinceId")) {
			waitForElementVisible(driver, AdminAddNewAddressesPageUI.INFO_DROPDOWN_BY_NAME, nameInfo);
			return getFirstSelectedTextInDefaultDropdown(driver, AdminAddNewAddressesPageUI.INFO_DROPDOWN_BY_NAME, nameInfo);
		} else {
			waitForElementVisible(driver, AdminAddNewAddressesPageUI.INFO_TEXTBOX_BY_NAME, nameInfo);
			return getElementAttribute(driver, AdminAddNewAddressesPageUI.INFO_TEXTBOX_BY_NAME, "value", nameInfo);
		}
	}
	
	public boolean verifyAddedNewAddress(Address address) {
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
	
	public AdminEditCustomerDetailsPageObject backToCustomerList() {
		waitForElementClickable(driver, AdminAddNewAddressesPageUI.BACK_TO_CUSTOMER_BUTTON);
		clickToElement(driver, AdminAddNewAddressesPageUI.BACK_TO_CUSTOMER_BUTTON);
		return PageGeneratorManager.getAdminEditCustomerDetailsPage(driver);
	}
	
	
}
