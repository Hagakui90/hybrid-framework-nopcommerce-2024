package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObjects.guest.CategoriesSideBarPageObject;

public class DesktopsSubPageObject extends CategoriesSideBarPageObject {
	WebDriver driver;

	public DesktopsSubPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	

}
