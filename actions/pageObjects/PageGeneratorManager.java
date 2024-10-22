package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static CustomerPageObject getCustomerPageObject(WebDriver driver) {
		return new CustomerPageObject(driver);
	}
	
}
