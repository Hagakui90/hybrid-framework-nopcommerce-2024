package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminEditProductDetailsPageUI;

public class AdminEditProductDetailsPageObject extends BasePage {
	WebDriver driver;

	public AdminEditProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void expandDetailItem(String cardName) {
		waitForElementClickable(driver, AdminEditProductDetailsPageUI.CARD_COLLAPSE_BUTTON, cardName);
		String statusCollapseButton = getElementAttribute(driver, AdminEditProductDetailsPageUI.CARD_COLLAPSE_BUTTON, "class", cardName);
		System.out.println(statusCollapseButton);
		if (statusCollapseButton.contains("fa-plus")) {
			clickToElement(driver, AdminEditProductDetailsPageUI.CARD_COLLAPSE_BUTTON, cardName);
		}
	}
}
