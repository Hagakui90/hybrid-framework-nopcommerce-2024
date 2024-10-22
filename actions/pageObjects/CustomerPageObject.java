package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage{

	WebDriver driver;
	
	
	public CustomerPageObject(WebDriver driver) {
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
