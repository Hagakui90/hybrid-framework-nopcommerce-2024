package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageUIs.user.ChangePasswordPageUI;
import pageUIs.user.MyAccountSideBarPageUI;



public class ChangePasswordPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;
	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void inputChangePasswordForm(String oldPassword, String newPassword) {
		waitForElementVisible(driver, ChangePasswordPageUI.PASSWORD_TEXTBOXES, "OldPassword");
		sendkeyToElement(driver, ChangePasswordPageUI.PASSWORD_TEXTBOXES, oldPassword, "OldPassword");
		
		waitForElementVisible(driver, ChangePasswordPageUI.PASSWORD_TEXTBOXES, "NewPassword");
		sendkeyToElement(driver, ChangePasswordPageUI.PASSWORD_TEXTBOXES, newPassword, "NewPassword");
		
		waitForElementVisible(driver, ChangePasswordPageUI.PASSWORD_TEXTBOXES, "ConfirmNewPassword");
		sendkeyToElement(driver, ChangePasswordPageUI.PASSWORD_TEXTBOXES, newPassword, "ConfirmNewPassword");
		
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getChangePasswordNotificationBarText() {
		waitForElementVisible(driver, ChangePasswordPageUI.CHANGED_PASSWORD_NOTIFICATION_BAR);
		return getElementText(driver, ChangePasswordPageUI.CHANGED_PASSWORD_NOTIFICATION_BAR);
	}

	public HomePageObject logout() {
		waitForElementClickable(driver, MyAccountSideBarPageUI.LOGOUT_LINK_TEXT);
		clickToElementByJS(driver, MyAccountSideBarPageUI.LOGOUT_LINK_TEXT);
		return PageGeneratorManager.getHomePageObject(driver);
	}
	
}
