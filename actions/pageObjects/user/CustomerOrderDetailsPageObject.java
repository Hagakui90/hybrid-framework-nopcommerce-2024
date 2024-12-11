package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CustomerOrderDetailPageUI;

public class CustomerOrderDetailsPageObject extends BasePage{
	WebDriver driver;

	public CustomerOrderDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitleText() {
		waitForElementVisible(driver, CustomerOrderDetailPageUI.PAGE_TITLE_TEXT);
		return getElementText(driver, CustomerOrderDetailPageUI.PAGE_TITLE_TEXT);
	}
	
}
