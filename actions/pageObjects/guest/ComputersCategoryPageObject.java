package pageObjects.guest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.GlobalConstants;
import pageUIs.guest.ComputersCategoryPageUI;

public class ComputersCategoryPageObject extends CategoiesSideBarPageObject {
	WebDriver driver;

	public ComputersCategoryPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean verifySortNameAscending() {
		waitForElementClickable(driver, ComputersCategoryPageUI.SORT_DROPDOWN);
		selectItemInDefaultDropdown(driver, ComputersCategoryPageUI.SORT_DROPDOWN, "Name Asc");
		List<WebElement> actualProductName = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, ComputersCategoryPageUI.SORT_DROPDOWN)));
		List<String> expectedProductName = new ArrayList<String>();
		for (WebElement productName : actualProductName) {
			expectedProductName.add(productName.getText());
		}
		Collections.sort(expectedProductName);
		return actualProductName.equals(expectedProductName);
	}
}
