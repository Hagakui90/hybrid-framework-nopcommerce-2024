package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import pageUIs.admin.AdminCustomersCustomersPageUI;

public class AdminCustomersCustomersPageObject extends AdminDashboardSideBarPageObject{
	WebDriver driver;

	public AdminCustomersCustomersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickToAddNewButton() {
		waitForElementVisible(driver, AdminCustomersCustomersPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminCustomersCustomersPageUI.ADD_NEW_BUTTON);
	}
}
