package pageObjects.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.Customer;
import pageUIs.admin.AdminCatalogProductsPageUI;
import pageUIs.admin.AdminCustomersCustomersPageUI;

public class AdminCustomersCustomersPageObject extends AdminDashboardSideBarPageObject {
	WebDriver driver;

	public AdminCustomersCustomersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementVisible(driver, AdminCustomersCustomersPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminCustomersCustomersPageUI.ADD_NEW_BUTTON);
	}

	public void searchListCustomerRoles(String role) {
		waitForElementVisible(driver, AdminCustomersCustomersPageUI.CUSTOMER_ROLE_TEXTBOX);
		clickToElement(driver, AdminCustomersCustomersPageUI.CUSTOMER_ROLE_TEXTBOX);
		waitForElementClickable(driver, AdminCustomersCustomersPageUI.CUSTOMER_ROLE_CUSTOM_DROPDOWN);
		selectItemInCustomDropdown(driver, AdminCustomersCustomersPageUI.CUSTOMER_ROLE_CUSTOM_DROPDOWN, AdminCustomersCustomersPageUI.CUSTOMER_ROLE, role);
		waitForElementVisible(driver, AdminCustomersCustomersPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminCustomersCustomersPageUI.SEARCH_BUTTON);
	}

	public boolean isNextPageButtonActived(String currentNumberPage) {
		waitForElementVisible(driver, AdminCustomersCustomersPageUI.NEXT_PAGE_LINK_TEXT);
		if (getElementAttribute(driver, AdminCustomersCustomersPageUI.NEXT_PAGE_LINK_TEXT, "class").contains("disabled")) {
			System.out.println("Next button is not actived.");
			return false;
		} else
			return true;
	}

	public boolean verifyCustomer(Customer customer) {
		int companyColumnIndex = getListElementSize(driver, AdminCustomersCustomersPageUI.COLUMN_INDEX_BY_NAME, "company") + 1;
		waitForElementVisible(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		String currentNumberPage = getElementText(driver, AdminCatalogProductsPageUI.ACTIVE_PAGE_LINK);
		List<WebElement> listCustomerResult = getListWebElement(driver, AdminCustomersCustomersPageUI.LIST_CUSTOMER_RESULT);
		do {
			for (int i = 0; i < listCustomerResult.size(); i++) {
				waitForElementVisible(driver, AdminCustomersCustomersPageUI.VALUE_BY_COLUMN_INDEX, String.valueOf(i + 1), String.valueOf(companyColumnIndex));
				if (getElementText(driver, AdminCustomersCustomersPageUI.VALUE_BY_COLUMN_INDEX, String.valueOf(i + 1), String.valueOf(companyColumnIndex)).equals(customer.getCompany())) {
					return true;
				}
			}
			waitForElementVisible(driver, AdminCustomersCustomersPageUI.NEXT_PAGE_LINK_TEXT, currentNumberPage);
			clickToElementByJS(driver, AdminCustomersCustomersPageUI.NEXT_PAGE_LINK_TEXT, currentNumberPage);
			currentNumberPage = getElementText(driver, AdminCustomersCustomersPageUI.ACTIVE_PAGE_LINK);
		} while (isNextPageButtonActived(currentNumberPage));
		return false;
	}
}
