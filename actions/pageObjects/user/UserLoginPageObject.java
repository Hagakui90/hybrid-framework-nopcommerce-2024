package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	WebDriver driver;
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailAddress(String emailAddress) {
			waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
			sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPassword(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);		
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserLoginPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getHomePageObject(driver);
	}
	
	public HomePageObject enterToLoginForm(String emailAddress, String password) {
		enterToEmailAddress(emailAddress);
		enterToPassword(password);
		return clickToLoginButton();
	}
	public String getEmailErrorTextMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getEmailNotExistTextMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_VALIDATION_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_VALIDATION_ERROR_MESSAGE);
	}

}
