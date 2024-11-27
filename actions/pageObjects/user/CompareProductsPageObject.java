package pageObjects.user;

import org.openqa.selenium.WebDriver;



public class CompareProductsPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;

	public CompareProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean verifyAddedProductInComparableTable(String nameProduct) {
		
		return true;
	}
}
