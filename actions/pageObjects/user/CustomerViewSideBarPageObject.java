package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.CustomerViewSideBarPageUI;

public class CustomerViewSideBarPageObject extends BasePage{

	WebDriver driver;
	public CustomerViewSideBarPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public String getPageTitle(String pageName) {
		waitForElementVisible(driver, CustomerViewSideBarPageUI.PAGE_TITLE_TEXT, pageName);
		return getElementText(driver, CustomerViewSideBarPageUI.PAGE_TITLE_TEXT, pageName);
	}
	
	
}
