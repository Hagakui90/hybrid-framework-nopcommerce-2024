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

	public String getEmailAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getLastNameTextboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getFirstNameTextboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementVisible(driver, CustomerPageUI.LOGOUT_LINK);
		clickToElement(driver, CustomerPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePageObject(driver);
	}

}
