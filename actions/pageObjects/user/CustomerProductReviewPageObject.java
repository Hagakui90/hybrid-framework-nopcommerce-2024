package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class CustomerProductReviewPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public CustomerProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
