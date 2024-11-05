package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerAddressPageUI;

public class CustomerAddressObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public CustomerAddressObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void openAddressForm() {
		waitForElementClickable(driver, CustomerAddressPageUI.ADD_BUTTON);
		clickToElement(driver, CustomerAddressPageUI.ADD_BUTTON);
	}
	
	public void inputAddressForm(String firstName, String lastName, String email, String company, String country, String state,
			String city, String address1, String address2, String zipPostalCode, String phoneNumber, String faxNumber) {
		waitForElementVisible(driver, CustomerAddressPageUI.INFO_ADDRESS_TEXTBOX, firstName);
	}
}
