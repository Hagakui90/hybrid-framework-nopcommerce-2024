package pageObjects.admin;

import org.openqa.selenium.WebDriver;

public class AdminDashboardPageObject extends AdminDashboardSideBarPageObject{
	WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	
	
}
