package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.BuildYourOwnComputerPageUI;

public class BuildYourOwnComputerPageObject extends DetailProductPageObject{
	WebDriver driver;

	public BuildYourOwnComputerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void checkEveryRadioOrCheckBox(String label, String idAttribute, String dataAttributeValue) {
		waitForElementVisible(driver, BuildYourOwnComputerPageUI.CHECKBOX, label, idAttribute, dataAttributeValue);
		checkToElement(driver, BuildYourOwnComputerPageUI.CHECKBOX, label, idAttribute, dataAttributeValue);
	}
	
	public void buildOwnComputer() {
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.PROCESSOR_DROPDOWN);
		selectItemInDefaultDropdown(driver, BuildYourOwnComputerPageUI.PROCESSOR_DROPDOWN, "products.productattributes.priceadjustment");
		
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.RAM_DROPDOWN);
		selectItemInDefaultDropdown(driver, BuildYourOwnComputerPageUI.RAM_DROPDOWN, "products.productattributes.priceadjustment");

		checkEveryRadioOrCheckBox("HDD", "3", "7");
		checkEveryRadioOrCheckBox("OS", "4", "9");
		checkEveryRadioOrCheckBox("Software", "5", "10");
		checkEveryRadioOrCheckBox("Software", "5", "11");
		checkEveryRadioOrCheckBox("Software", "5", "12");
		
		waitForElementClickable(driver, BuildYourOwnComputerPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, BuildYourOwnComputerPageUI.ADD_TO_CART_BUTTON);
		closeReviewNotiBar();
	}
	
	public String getTextNotificationBar() {
		waitForElementVisible(driver, BuildYourOwnComputerPageUI.NOTIFICATION_BAR);
		return getElementText(driver, BuildYourOwnComputerPageUI.NOTIFICATION_BAR);
	}
	
	
}
