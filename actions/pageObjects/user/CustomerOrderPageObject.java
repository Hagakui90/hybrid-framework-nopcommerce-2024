package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerOrderPageUI;

public class CustomerOrderPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public CustomerOrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickToDetailCustomerOrderByOrderNumber(String orderNumber) {
		waitForElementVisible(driver, CustomerOrderPageUI.DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber);
		clickToElement(driver, CustomerOrderPageUI.DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber); 
	}
}
