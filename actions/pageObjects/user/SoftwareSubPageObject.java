package pageObjects.user;

import org.openqa.selenium.WebDriver;

import pageObjects.guest.CategoriesSideBarPageObject;

public class SoftwareSubPageObject extends CategoriesSideBarPageObject {
	WebDriver driver;

	public SoftwareSubPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	

}
