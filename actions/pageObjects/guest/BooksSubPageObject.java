package pageObjects.guest;

import org.openqa.selenium.WebDriver;

public class BooksSubPageObject extends CategoriesSideBarPageObject{
	WebDriver driver;
	public BooksSubPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


}
