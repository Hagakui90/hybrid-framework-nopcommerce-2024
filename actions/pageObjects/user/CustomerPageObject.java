package pageObjects.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.GlobalConstants;
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
		return PageGeneratorManager.getHomePageObject(driver);
	}

	public void updateFullInfo(String gender, String firstName, String lastName, String newEmail, String companyName) {
		waitForElementVisible(driver, CustomerPageUI.GENDER_RADIOBUTTON, gender.toLowerCase());
		checkToElement(driver, CustomerPageUI.GENDER_RADIOBUTTON, gender);
		
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, firstName);
		
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.LASTNAME_TEXTBOX, lastName);
		
		waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.EMAIL_TEXTBOX, newEmail);
		
		waitForElementClickable(driver, CustomerPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerPageUI.SAVE_BUTTON);
	}

	
	

}
