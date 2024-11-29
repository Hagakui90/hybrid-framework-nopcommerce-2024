package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class BuildYourOwnComputerPageObject extends DetailProductPageObject{
	WebDriver driver;

	public BuildYourOwnComputerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
