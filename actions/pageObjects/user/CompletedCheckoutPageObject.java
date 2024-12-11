package pageObjects.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.Order;
import commons.PageGeneratorManager;
import pageUIs.user.CompletedCheckoutPageUI;

public class CompletedCheckoutPageObject extends CheckoutPageObject {
	WebDriver driver;

	public CompletedCheckoutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getPageTitleText() {
		waitForElementVisible(driver, CompletedCheckoutPageUI.PAGE_TITLE_TEXT);
		return getElementText(driver, CompletedCheckoutPageUI.PAGE_TITLE_TEXT);
	}

	public String getOrderCompletedTitleText() {
		waitForElementVisible(driver, CompletedCheckoutPageUI.ORDER_COMPLETED_TITLE_TEXT);
		return getElementText(driver, CompletedCheckoutPageUI.ORDER_COMPLETED_TITLE_TEXT);
	}

	public Order createCompletedOrder(Order draftedOrder) {
		draftedOrder.setOrderNumber(getOrderNumberText());
		draftedOrder.setOrderDate(getOrderDateText());
		return draftedOrder;
	}

	public String getOrderNumberText() {
		waitForElementVisible(driver, CompletedCheckoutPageUI.ORDER_NUMBER_TEXT);
		String detail = getElementText(driver, CompletedCheckoutPageUI.ORDER_NUMBER_TEXT);
		String orderNumber = detail.substring(22);
		System.out.println(orderNumber);
		return orderNumber;
	}
	
	public String getOrderDateText() {
		waitForElementVisible(driver, CompletedCheckoutPageUI.ORDER_NUMBER_TEXT);
		String detail = getElementText(driver, CompletedCheckoutPageUI.ORDER_NUMBER_TEXT);
		String orderNumber = detail.substring(22);
		System.out.println(orderNumber);
		return orderNumber;
	}

	public HomePageObject clickToThankYouContinueButton() {
		waitForElementVisible(driver, CompletedCheckoutPageUI.THANKYOU_CONTINUE_BUTTON);
		clickToElement(driver, CompletedCheckoutPageUI.THANKYOU_CONTINUE_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
