package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
	}

	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageObject(driver);
	}

	public CustomerPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPageObject(driver);
	}
	
	public DetailProductPageObject clickToProduct(String productName) {
		List<WebElement> productList = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, HomePageUI.PRODUCT_NAME_ITEM)));

		for (WebElement product : productList) {
			String expectedProduct = product.getText();
			if (expectedProduct.contains(productName)) {
				product.click();
				break;
			}
		}
		return PageGeneratorManager.getDetailProductPage(driver);
	}
	
	public void openHomeFooterPage(String blockName, String pageName) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_HOME_FOOTER_LINK_TEXT, blockName, pageName);
		clickToElement(driver, HomePageUI.DYNAMIC_HOME_FOOTER_LINK_TEXT, blockName, pageName);
		sleepInSecond(3);
	}

	public void openHomeHeaderMenuPage(String menuPage) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_HOME_HEADER_MENU_LINK_TEXT, menuPage);
		clickToElement(driver, HomePageUI.DYNAMIC_HOME_HEADER_MENU_LINK_TEXT, menuPage);
	}

}
