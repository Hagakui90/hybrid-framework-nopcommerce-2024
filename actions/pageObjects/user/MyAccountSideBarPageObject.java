package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage{
	WebDriver driver;
	public MyAccountSideBarPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void openDynamicSideBarPage(String pageName) {
		waitForElementClickable(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToElement(driver, MyAccountSideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
	}
	
	public void clickToLogoLink() {
		waitForElementVisible(driver, MyAccountSideBarPageUI.LOGO_LINK_TEXT);
		clickToElement(driver, MyAccountSideBarPageUI.LOGO_LINK_TEXT);
	}
}
