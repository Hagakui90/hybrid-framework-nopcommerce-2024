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
	
	public String getNoResultSearchText() {
		waitForElementVisible(driver, CustomerSearchPageUI.NO_RESULT_SEARCH_TEXT);
		return getElementText(driver, CustomerSearchPageUI.NO_RESULT_SEARCH_TEXT);
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
	
	public boolean verifyResultSearchAbsolutely(String keyword) {
		List<WebElement> listResultSearch = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, CustomerSearchPageUI.LIST_SEARCH_RESULT_TEXT)));
		int validResult =0;
		for (WebElement result : listResultSearch) {
			String expectedResult = result.getText();
			if (expectedResult.equals(keyword)) {
				validResult++;
			}
			
		}
		if (validResult == listResultSearch.size()) {
			return true;
		}
		else return false;
	}

	public void inputAdvancedSearchForm(String keyword, String categoryValue, String subCategoryValue, String manufacturerValue, String descriptionValue) {
		waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, CustomerSearchPageUI.SEARCH_TEXTBOX, keyword);
		waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, "advancedsearch");
		checkToElement(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, "advancedsearch");
		if (!categoryValue.equals("common.all")) {
			waitForElementClickable(driver, CustomerSearchPageUI.ADVANCED_SEARCH_DROPDOWN, "category");
			selectItemInDefaultDropdown(driver, CustomerSearchPageUI.ADVANCED_SEARCH_DROPDOWN, categoryValue, "category");
		}
		
		if (!subCategoryValue.equals("")) {
			waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, subCategoryValue);
			checkToElement(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, subCategoryValue);
		}
		
		if (!manufacturerValue.equals("common.all")) {
			waitForElementClickable(driver, CustomerSearchPageUI.ADVANCED_SEARCH_DROPDOWN, "manufacturer");
			selectItemInDefaultDropdown(driver, CustomerSearchPageUI.ADVANCED_SEARCH_DROPDOWN, manufacturerValue, "manufacturer");
		}
		
		if (!descriptionValue.equals("")) {
			waitForElementVisible(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, "descriptions");
			checkToElement(driver, CustomerSearchPageUI.SEARCH_CHECKBOX, "descriptions");
		}
		waitForElementClickable(driver, CustomerSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, CustomerSearchPageUI.SEARCH_BUTTON);
	}
	
	public void updateProductToShoppingCart(String keyword) {
		List<WebElement> listResultSearch = getListWebElement(driver, CustomerSearchPageUI.LIST_SEARCH_RESULT_TEXT);
		for (WebElement result : listResultSearch) {
			String expectedResult = result.getText();
			if (expectedResult.equals(keyword)) {
				waitForElementClickable(driver, CustomerSearchPageUI.ADD_TO_CART_BUTTON_BY_NAME, keyword);
				clickToElement(driver, CustomerSearchPageUI.ADD_TO_CART_BUTTON_BY_NAME, keyword);
				closeReviewNotiBar();
				waitForElementInVisible(driver, CustomerSearchPageUI.NOTIFICATION_BAR);
			}
		}
		
	}

}
