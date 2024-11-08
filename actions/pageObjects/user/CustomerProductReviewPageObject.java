package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerProductReviewsPageUI;

public class CustomerProductReviewPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public CustomerProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public String getAddedReviewTitleText() {
		waitForElementInVisible(driver, CustomerProductReviewsPageUI.LATEST_REVIEW_TITLE);
		return getElementText(driver, CustomerProductReviewsPageUI.LATEST_REVIEW_TITLE);
	}
	
	public String getAddedReviewRatingValue() {
		waitForElementVisible(driver, CustomerProductReviewsPageUI.LATEST_REVIEW_RATING);
		String valuleRatingInString = getElementAttribute(driver, CustomerProductReviewsPageUI.LATEST_REVIEW_RATING, "style");
		return String.valueOf(getValueRatingInInteger(valuleRatingInString));
	}
	
	public int getValueRatingInInteger(String valueAttributeInText) {
		String valueInString = valueAttributeInText.substring(7, valueAttributeInText.length()-2);
		return (Integer.valueOf(valueInString))/20;
	}
}
