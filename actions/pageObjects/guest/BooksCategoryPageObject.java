package pageObjects.guest;

import org.openqa.selenium.WebDriver;

public class BooksCategoryPageObject extends CategoriesSideBarPageObject{
	WebDriver driver;
	public BooksCategoryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


}
