package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountLink() {
		waitForElementVisible(driver, RegisterPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, RegisterPageUI.MY_ACCOUNT_LINK);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getFirstNameErrorTextMessage() {
		waitForElementVisible(driver, RegisterPageUI.FRISTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.FRISTNAME_ERROR_MSG);
	}

	public String getLastNameErrorTextMessage() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
	}

	public String getEmailErrorTextMessage() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
	}

	public String getConfirmPasswordErrorTextMessage() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
	}

	public void clickToNopCommerceLogo() {
		waitForElementVisible(driver, RegisterPageUI.NOPCOMMERCE_LOGO);
		clickToElement(driver, RegisterPageUI.NOPCOMMERCE_LOGO);
		
	}

	public void enterToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
		
	}

	public void enterToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmpass) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmpass);
		
	}

	public String getCompletedRegisterTextMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
		return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
	}

	public String getExistingEmailErrorTextMessage() {
		waitForElementVisible(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.EXISTING_EMAIL_ERROR_MSG);
	}

	public String getInvalidPasswordTextMessage() {
		waitForElementVisible(driver, RegisterPageUI.INVALID_PASSWORD_ERROR_MSG);
		return getElementText(driver, RegisterPageUI.INVALID_PASSWORD_ERROR_MSG);
	}

}
