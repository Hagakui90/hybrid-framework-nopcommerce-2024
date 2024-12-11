package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class CustomerOrderPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public CustomerOrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
