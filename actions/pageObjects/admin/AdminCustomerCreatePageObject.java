package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.Customer;
import pageUIs.admin.AdminCustomerCreatePageUI;

public class AdminCustomerCreatePageObject extends AdminDashboardSideBarPageObject{
	WebDriver driver;

	public AdminCustomerCreatePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public Customer createCustomerInfo(String email, String password, String firstName, String lastName, String sex, String company, String role, boolean active, String adminComment) {
		return new Customer(email, password, firstName, lastName, sex, company, role, active, adminComment);
	}

	public void inputToAddNewForm(Customer newCustomer) {
		waitForElementVisible(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "Email");
		waitForElementVisible(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "Password");
		waitForElementVisible(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "FirstName");
		waitForElementVisible(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "LastName");
		waitForElementVisible(driver, AdminCustomerCreatePageUI.GENDER_CUSTOMER_RADIO_BUTTON_BY_NAME, "Male");
		waitForElementVisible(driver, AdminCustomerCreatePageUI.GENDER_CUSTOMER_RADIO_BUTTON_BY_NAME, "Female");
		waitForElementVisible(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, "Company");
		waitForElementVisible(driver, AdminCustomerCreatePageUI.CUSTOMER_ROLE_TEXTBOX);
		waitForElementVisible(driver, AdminCustomerCreatePageUI.ACTIVE_CHECKBOX);
		waitForElementVisible(driver, AdminCustomerCreatePageUI.ADMIN_COMMENT_TEXTAREA);
		
		sendkeyToElement(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, newCustomer.getEmail(), "Email");
		sendkeyToElement(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, newCustomer.getPassword(), "Password");
		sendkeyToElement(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, newCustomer.getFirstName(), "FirstName");
		sendkeyToElement(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, newCustomer.getLastName(), "LastName");
		if (newCustomer.getSex().equals("Female")) {
			checkToElement(driver, AdminCustomerCreatePageUI.GENDER_CUSTOMER_RADIO_BUTTON_BY_NAME, "Female");
		} else {
			checkToElement(driver, AdminCustomerCreatePageUI.GENDER_CUSTOMER_RADIO_BUTTON_BY_NAME, "Male");
		}
		sendkeyToElement(driver, AdminCustomerCreatePageUI.INFO_CUSTOMER_TEXTBOX_BY_NAME, newCustomer.getCompany(), "Company");
		clickToElement(driver, AdminCustomerCreatePageUI.CUSTOMER_ROLE_TEXTBOX);
		waitForElementClickable(driver, AdminCustomerCreatePageUI.CUSTOMER_ROLE_CUSTOM_DROPDOWN);
		selectItemInCustomDropdown(driver, AdminCustomerCreatePageUI.CUSTOMER_ROLE_CUSTOM_DROPDOWN, AdminCustomerCreatePageUI.CUSTOMER_ROLE, "Guests");
		sendkeyToElement(driver, AdminCustomerCreatePageUI.ADMIN_COMMENT_TEXTAREA, newCustomer.getAdminComment());
	}

	public void clickToSaveButton(String typeSave) {
		waitForElementClickable(driver, AdminCustomerCreatePageUI.SUBMIT_BUTTON_BY_NAME, typeSave);
		clickToElement(driver, AdminCustomerCreatePageUI.SUBMIT_BUTTON_BY_NAME, typeSave);
	}

	public String getAlertSuccessMessage() {
		waitForElementVisible(driver, AdminCustomerCreatePageUI.ALERT_SUCCESS_MESSAGE);
		return getElementText(driver, AdminCustomerCreatePageUI.ALERT_SUCCESS_MESSAGE);
	}

}
