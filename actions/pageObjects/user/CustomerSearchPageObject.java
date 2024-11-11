package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.GlobalConstants;
import pageUIs.user.CustomerSearchPageUI;

public class CustomerSearchPageObject extends CustomerViewSideBarPageObject {
	WebDriver driver;

	public CustomerSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void inputSearchForm(String keyword) {
		waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, CustomerSearchPageUI.SEARCH_TEXTBOX, keyword);
		
		waitForElementClickable(driver, CustomerSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, CustomerSearchPageUI.SEARCH_BUTTON);
	}
	
	public String getWarningText() {
		waitForElementVisible(driver, CustomerSearchPageUI.WARNING_MESSAGE_TEXT);
		return getElementText(driver, CustomerSearchPageUI.WARNING_MESSAGE_TEXT);
	}
	
	public String getResultText() {
		waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_RESULT_TEXT);
		return getElementText(driver, CustomerSearchPageUI.SEARCH_RESULT_TEXT);
	}

	public boolean verifyResultSearchRelatively() {
		List<WebElement> listResultSearch = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CustomerSearchPageUI.LIST_SEARCH_RESULT_TEXT)));
		int validResult =0;
		for (WebElement result : listResultSearch) {
			String expectedResult = result.getText();
			if (expectedResult.equals("Lenovo IdeaCentre")||expectedResult.equals("Lenovo Thinkpad Carbon Laptop")) {
				validResult++;
			}
			
		}
		if (validResult == listResultSearch.size()) {
			return true;
		}
		else return false;
	}
	
	public boolean verifyResultSearchAbsolutely() {
		List<WebElement> listResultSearch = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CustomerSearchPageUI.LIST_SEARCH_RESULT_TEXT)));
		int validResult =0;
		for (WebElement result : listResultSearch) {
			String expectedResult = result.getText();
			if (expectedResult.equals("Lenovo Thinkpad Carbon Laptop")) {
				validResult++;
			}
			
		}
		if (validResult == listResultSearch.size()) {
			return true;
		}
		else return false;
	}

	public void inputAdvancedSearchForm(String keyword, String searchValue, String advancedValue, String filterValue) {
		waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, CustomerSearchPageUI.SEARCH_TEXTBOX, keyword);
		waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, searchValue);
		checkToElement(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, searchValue);
		waitForElementClickable(driver, CustomerSearchPageUI.ADVANCED_SEARCH_DROPDOWN, advancedValue);
		selectItemInDefaultDropdown(driver, CustomerSearchPageUI.ADVANCED_SEARCH_DROPDOWN, filterValue, advancedValue);
		waitForElementClickable(driver, CustomerSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, CustomerSearchPageUI.SEARCH_BUTTON);
	}

}
