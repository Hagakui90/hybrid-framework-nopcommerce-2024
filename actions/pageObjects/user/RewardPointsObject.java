package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class RewardPointsObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public RewardPointsObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
