package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.user.DetailProductPageUI;

public class DetailProductPageObject extends HomePageObject{
	WebDriver driver;
	public DetailProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getTitleDetailProduct() {
		waitForElementVisible(driver, DetailProductPageUI.PRODUCT_NAME_TEXT);
		return getElementText(driver, DetailProductPageUI.PRODUCT_NAME_TEXT);
	}
	
	
	public void inputReviewForm(String titleReview, String contentReview, String rating) {
		clickToAddReviewLink();
		
		waitForElementVisible(driver, DetailProductPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, DetailProductPageUI.TITLE_TEXTBOX, titleReview);
		
		waitForElementVisible(driver, DetailProductPageUI.REVIEW_TEXTAREA);
		sendkeyToElement(driver, DetailProductPageUI.REVIEW_TEXTAREA, contentReview);
		
		waitForElementVisible(driver, DetailProductPageUI.RATING_RADIO_CHECK, rating);
		checkToElement(driver, DetailProductPageUI.RATING_RADIO_CHECK, rating);
		
		waitForElementClickable(driver, DetailProductPageUI.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, DetailProductPageUI.SUBMIT_REVIEW_BUTTON);
	}

	public String getTextNotificationBar() {
		waitForElementVisible(driver, DetailProductPageUI.NOTIFICATION_BAR);
		return getElementText(driver, DetailProductPageUI.NOTIFICATION_BAR);
	}
	public void closeReviewNotiBar() {
		/*
		 * waitForElementClickable(driver, DetailProductPageUI.CLOSE_REVEW_NOTI_BAR); clickToElement(driver,
		 * DetailProductPageUI.CLOSE_REVEW_NOTI_BAR); scrollToElementOnTop(driver, DetailProductPageUI.HEADER_AREA);
		 */
		clickToElementByJS(driver, DetailProductPageUI.CLOSE_REVEW_NOTI_BAR);
	}
	
	public CustomerPageObject clickToMyAccountLink() {
		/*
		 * waitForElementClickable(driver, DetailProductPageUI.MYACCOUNT_LINK); clickToElement(driver, DetailProductPageUI.MYACCOUNT_LINK);
		 */
		clickToElementByJS(driver, DetailProductPageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPageObject(driver);
	}
	
	public void clickToAddReviewLink() {
		List<WebElement> linkList = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, DetailProductPageUI.ADD_REVIEW_LINK_TEXT)));
		for (WebElement link : linkList) {
			String expectedLink = link.getText();
			if (expectedLink.equals("reviews.overview.addnew")||expectedLink.equals("reviews.overview.first")) {
				link.click();
				break;
			}
		}
	}
	
	public void clickToAddToWishlist() {
		waitForElementClickable(driver, DetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
		clickToElement(driver, DetailProductPageUI.ADD_TO_WISHLIST_BUTTON);
	}
	
	public String getPriceProduct() {
		waitForElementVisible(driver, DetailProductPageUI.PRODUCT_PRICE_TEXT);
		return getElementText(driver, DetailProductPageUI.PRODUCT_PRICE_TEXT);
	}
}
