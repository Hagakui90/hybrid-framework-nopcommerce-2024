package pageObjects.guest;


import org.openqa.selenium.WebDriver;

public class ComputersCategoryPageObject extends CategoiesSideBarPageObject {
	WebDriver driver;

	public ComputersCategoryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	

}
