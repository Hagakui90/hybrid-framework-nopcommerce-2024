package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageUIs.user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBarPageObject {

	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getInfoTextboxAttributeValue(String infoName) {
		waitForElementVisible(driver, CustomerPageUI.INFO_TEXTBOX, infoName);
		return getElementAttribute(driver, CustomerPageUI.INFO_TEXTBOX, "value", infoName);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementVisible(driver, CustomerPageUI.LOGOUT_LINK);
		clickToElement(driver, CustomerPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public void updateFullInfo(String gender, String firstName, String lastName, String newEmail, String companyName) {
		waitForElementVisible(driver, CustomerPageUI.GENDER_RADIOBUTTON, gender.toLowerCase());
		checkToElement(driver, CustomerPageUI.GENDER_RADIOBUTTON, gender.toLowerCase());

		waitForElementVisible(driver, CustomerPageUI.INFO_TEXTBOX, "account.fields.firstname");
		sendkeyToElement(driver, CustomerPageUI.INFO_TEXTBOX, firstName, "account.fields.firstname");

		waitForElementVisible(driver, CustomerPageUI.INFO_TEXTBOX, "account.fields.lastname");
		sendkeyToElement(driver, CustomerPageUI.INFO_TEXTBOX, lastName, "account.fields.lastname");

		waitForElementVisible(driver, CustomerPageUI.INFO_TEXTBOX, "account.fields.email");
		sendkeyToElement(driver, CustomerPageUI.INFO_TEXTBOX, newEmail, "account.fields.email");
		
		waitForElementVisible(driver, CustomerPageUI.INFO_TEXTBOX, "account.fields.company");
		sendkeyToElement(driver, CustomerPageUI.INFO_TEXTBOX, companyName, "account.fields.company");

		waitForElementClickable(driver, CustomerPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerPageUI.SAVE_BUTTON);
	}
	
	public boolean verifyCheckedGenderRadiobox(String gender) {
		waitForElementVisible(driver, CustomerPageUI.GENDER_RADIOBUTTON, gender.toLowerCase());
		return getWebElement(driver, CustomerPageUI.GENDER_RADIOBUTTON, gender.toLowerCase()).isSelected();
	}

	public String getUpdatedNotificationBarText() {
		waitForElementVisible(driver, CustomerPageUI.UPDATED_NOTIFICATION_BAR);
		return getElementText(driver, CustomerPageUI.UPDATED_NOTIFICATION_BAR);
	}
	

}
