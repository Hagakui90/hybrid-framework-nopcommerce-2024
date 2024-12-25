package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminEditCustomerDetailsPageUI;

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
	
	
}
