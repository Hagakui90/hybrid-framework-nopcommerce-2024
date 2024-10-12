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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	public void enterToFirstNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToLastNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToConfirmPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getCompletedRegisterTextMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExistingEmailErrorTextMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInvalidPasswordTextMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
