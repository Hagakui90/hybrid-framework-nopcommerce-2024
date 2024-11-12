package pageObjects.guest;

import org.openqa.selenium.WebDriver;

public class NotebooksSubPageObject extends CategoiesSideBarPageObject {
	WebDriver driver;

	public NotebooksSubPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	

}
