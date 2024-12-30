package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.Address;
import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminEditCustomerDetailsPageUI;
import pageUIs.admin.AdminEditProductDetailsPageUI;

public class AdminEditCustomerDetailsPageObject extends BasePage{
	WebDriver driver;

	public AdminEditCustomerDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getAlertSuccessMessage() {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.ALERT_SUCCESS_MESSAGE);
		return getElementText(driver, AdminEditCustomerDetailsPageUI.ALERT_SUCCESS_MESSAGE);
	}

	public boolean verifyEmail(String email) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "Email");
		if (getElementAttribute(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "value", "Email").equals(email)) {
			return true;
		}
		return false;
	}

	public boolean verifyFirstName(String firstName) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "FirstName");
		if (getElementAttribute(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "value", "FirstName").equals(firstName)) {
			return true;
		}
		return false;
	}

	public boolean verifyLastName(String lastName) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "LastName");
		if (getElementAttribute(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "value", "LastName").equals(lastName)) {
			return true;
		}
		return false;
	}

	public boolean verifyGender(String sex) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.SELECTED_GENDER_RADIO_BUTTON);
		if (getElementAttribute(driver, AdminEditCustomerDetailsPageUI.SELECTED_GENDER_RADIO_BUTTON, "id").contains(sex)) {
			return true;
		}
		return false;
	}

	public boolean verifyCompany(String company) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "Company");
		if (getElementAttribute(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "value", "Company").contains(company)) {
			return true;
		}
		return false;
	}

	public boolean verifyRole(String role) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.SELECTED_ROLE);
		if (getElementAttribute(driver, AdminEditCustomerDetailsPageUI.SELECTED_ROLE, "title").contains(role)) {
			return true;
		}
		return false;
	}

	public boolean verifyActive(boolean active) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.ACTIVE_CHECKBOX);
		System.out.println(getElementAttribute(driver, AdminEditCustomerDetailsPageUI.ACTIVE_CHECKBOX, "value"));
		if (Boolean.valueOf(getElementAttribute(driver, AdminEditCustomerDetailsPageUI.ACTIVE_CHECKBOX, "value"))) {
			return true;
		}
		return false;
	}

	public boolean verifyAdminComment(String adminComment) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.ADMIN_COMMENT_TEXTAREA);
		if (getElementAttribute(driver, AdminEditCustomerDetailsPageUI.ADMIN_COMMENT_TEXTAREA, "value").contains(adminComment)) {
			return true;
		}
		return false;
	}
	
	public void clickToBackToList() {
		waitForElementClickable(driver, AdminEditCustomerDetailsPageUI.BACK_TO_LIST);
		clickToElement(driver, AdminEditCustomerDetailsPageUI.BACK_TO_LIST);
	}
	
	public void editCustomer(String email, String firstName, String lastName, String company, String adminComment) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "Email");
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "FirstName");
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "LastName");
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "Company");
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.ADMIN_COMMENT_TEXTAREA);
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.SUBMIT_BUTTON_BY_NAME, "save");
		
		sendkeyToElement(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, email, "Email");
		sendkeyToElement(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, firstName, "FirstName");
		sendkeyToElement(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, lastName, "LastName");
		sendkeyToElement(driver, AdminEditCustomerDetailsPageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, company, "Company");
		sendkeyToElement(driver, AdminEditCustomerDetailsPageUI.ADMIN_COMMENT_TEXTAREA, adminComment);
		clickToElement(driver, AdminEditCustomerDetailsPageUI.SUBMIT_BUTTON_BY_NAME, "save");
	}
	
	public void expandDetailItemByCardName(String cardName) {
		waitForElementClickable(driver, AdminEditCustomerDetailsPageUI.CARD_COLLAPSE_BUTTON, cardName);
		String statusCollapseButton = getElementAttribute(driver, AdminEditCustomerDetailsPageUI.CARD_COLLAPSE_BUTTON, "class", cardName);
		System.out.println(statusCollapseButton);
		if (statusCollapseButton.contains("fa-plus")) {
			clickToElement(driver, AdminEditProductDetailsPageUI.CARD_COLLAPSE_BUTTON, cardName);
		}
	}
	public AdminAddNewAddressesPageObject clickToAddNewAddress() {
		isPageLoadedSuccess(driver);
		expandDetailItemByCardName("addresses");
		waitForElementClickable(driver, AdminEditCustomerDetailsPageUI.ADD_ADDRESS_BUTTON);
		clickToElement(driver, AdminEditCustomerDetailsPageUI.ADD_ADDRESS_BUTTON);
		return PageGeneratorManager.getAdminAddNewAddressesPage(driver);
	}
	
	public String getValueEveryCellByRowAndColumn(String cardName, String rowNumber, String columnNumber) {
		waitForElementVisible(driver, AdminEditCustomerDetailsPageUI.VALUE_BY_COLUMN_INDEX_AND_CARD_NAME, cardName, rowNumber, columnNumber);
		return getElementText(driver, AdminEditCustomerDetailsPageUI.VALUE_BY_COLUMN_INDEX_AND_CARD_NAME, cardName, rowNumber, columnNumber);
	}
	
	public boolean verifyAddedNewAddressInList(Address address) {
		int lastNameColumnIndex = getListElementSize(driver, AdminEditCustomerDetailsPageUI.COLUMN_INDEX_BY_NAME_AND_CARD_NAME, "addresses", "lastname") + 1;
		int firstNameColumnIndex = lastNameColumnIndex - 1;
		int emailColumnIndex = getListElementSize(driver, AdminEditCustomerDetailsPageUI.COLUMN_INDEX_BY_NAME_AND_CARD_NAME, "addresses", "email") + 1;
		int phoneNumberColumnIndex = getListElementSize(driver, AdminEditCustomerDetailsPageUI.COLUMN_INDEX_BY_NAME_AND_CARD_NAME, "addresses", "phonenumber") + 1;
		int faxNumberColumnIndex = getListElementSize(driver, AdminEditCustomerDetailsPageUI.COLUMN_INDEX_BY_NAME_AND_CARD_NAME, "addresses", "faxnumber") + 1;
		int addressColumnIndex = getListElementSize(driver, AdminEditCustomerDetailsPageUI.COLUMN_INDEX_BY_NAME_AND_CARD_NAME, "addresses", "address") + 1;
		
		boolean verifyFirstName = getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(firstNameColumnIndex)).equals(address.getFirstName());
		boolean verifyLastName = getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(lastNameColumnIndex)).equals(address.getLastName());
		boolean verifyEmail = getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(emailColumnIndex)).equals(address.getEmail());
		boolean verifyPhoneNumber = getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(phoneNumberColumnIndex)).equals(address.getPhoneNumber());
		boolean verifyFaxNumber = getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(faxNumberColumnIndex)).equals(address.getFaxNumber());
		boolean verifyAddress = getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(addressColumnIndex)).contains(address.getCountry())
				&& getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(addressColumnIndex)).contains(address.getCity())
				&& getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(addressColumnIndex)).contains(address.getProvince())
				&& getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(addressColumnIndex)).contains(address.getAddress1())
				&& getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(addressColumnIndex)).contains(address.getAddress2())
				&& getValueEveryCellByRowAndColumn("addresses", "1", String.valueOf(addressColumnIndex)).contains(address.getZipPostalCode());
		return verifyFirstName && verifyLastName && verifyEmail && verifyPhoneNumber && verifyFaxNumber && verifyAddress;
	}
}
