package pageObjects.guest;

import org.openqa.selenium.WebDriver;

public class NotebooksSubPageObject extends CategoriesSideBarPageObject {
	WebDriver driver;

	public NotebooksSubPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	

}
