package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminLoginPageUI;
import pageUIs.user.UserLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailAddress(String emailAddress) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPassword(String password) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserLoginPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getAdminDashboardPageObject(driver);
	}

	public AdminDashboardPageObject enterToLoginForm (String emailAddress, String password) {
		enterToEmailAddress(emailAddress);
		enterToPassword(password);
		return clickToLoginButton();
	}
}
