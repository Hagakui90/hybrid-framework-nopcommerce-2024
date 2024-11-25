package pageObjects.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.Product;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminEditProductDetailsPageUI;

public class AdminEditProductDetailsPageObject extends BasePage {
	WebDriver driver;

	public AdminEditProductDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void expandDetailItemByCardName(String cardName) {
		waitForElementClickable(driver, AdminEditProductDetailsPageUI.CARD_COLLAPSE_BUTTON, cardName);
		String statusCollapseButton = getElementAttribute(driver, AdminEditProductDetailsPageUI.CARD_COLLAPSE_BUTTON, "class", cardName);
		System.out.println(statusCollapseButton);
		if (statusCollapseButton.contains("fa-plus")) {
			clickToElement(driver, AdminEditProductDetailsPageUI.CARD_COLLAPSE_BUTTON, cardName);
		}
	}
	
	public List<Date> getListCreatedOnOfOnePage() {
		int columnIndex = getListElementSize(driver, AdminEditProductDetailsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, "quantityhistory", "createdon") + 1;
		List<WebElement> listDetailsQuantityHistory = getListWebElement(driver, AdminEditProductDetailsPageUI.ALL_VALUES_COLUMN_INDEX, "quantityhistory", String.valueOf(columnIndex)) ;
		List<Date> listCreatedOnOfOnePage = new ArrayList<Date>();
		for (WebElement detailsItemString : listDetailsQuantityHistory) {
			listCreatedOnOfOnePage.add( convertStringToDate(detailsItemString.getText()));
		}
		return listCreatedOnOfOnePage;
	}
	
	public Date getLatestCreatedOnPerProductOfOnePage() {
		List<Date> detailsCreatedOn = new ArrayList<Date>();
		PageGeneratorManager.getAdminEditProductDetailsPage(driver);
		expandDetailItemByCardName("quantityhistory");
		detailsCreatedOn = getListCreatedOnOfOnePage();
		Collections.sort(detailsCreatedOn);
		return detailsCreatedOn.get(detailsCreatedOn.size() - 1);
	}
	
	public Date getLatestCreatedOnPerProduct() {
		List<Date> listCreatedOnPerProduct = new ArrayList<Date>();
		String currentNumberPage = getElementText(driver, AdminEditProductDetailsPageUI.ACTIVE_PAGE_LINK_EACH_CARD, "quantityhistory");
			listCreatedOnPerProduct.add(getLatestCreatedOnPerProductOfOnePage());
			while (isNextPageButtonActived(currentNumberPage)) {
			waitForElementVisible(driver, AdminEditProductDetailsPageUI.NEXT_BUTTON_EACH_CARD_BY_NUMBER_PAGE, "stockquantityhistory", currentNumberPage);
			clickToElementByJS(driver, AdminEditProductDetailsPageUI.NEXT_BUTTON_EACH_CARD_BY_NUMBER_PAGE, "stockquantityhistory", currentNumberPage);
			listCreatedOnPerProduct.add(getLatestCreatedOnPerProductOfOnePage());
			currentNumberPage = getElementText(driver, AdminEditProductDetailsPageUI.ACTIVE_PAGE_LINK_EACH_CARD, "quantityhistory");
		}
		Collections.sort(listCreatedOnPerProduct);
		return listCreatedOnPerProduct.get(listCreatedOnPerProduct.size()-1);
	}
	
	public Product getInforCreatedOnProduct() {
		waitForElementVisible(driver, AdminEditProductDetailsPageUI.NAME_OF_PRODUCT_TEXTFIELD);
		System.out.println("Product: " + getElementAttribute(driver, AdminEditProductDetailsPageUI.NAME_OF_PRODUCT_TEXTFIELD, "value"));
		return new Product(getElementAttribute(driver, AdminEditProductDetailsPageUI.NAME_OF_PRODUCT_TEXTFIELD, "value"), getLatestCreatedOnPerProduct());
	}
	
	public boolean isNextPageButtonActived(String currentNumberPage) {
		waitForElementVisible(driver, AdminEditProductDetailsPageUI.NEXT_BUTTON_EACH_CARD_BY_NUMBER_PAGE, "stockquantityhistory", currentNumberPage);
		if (getElementAttribute(driver, AdminEditProductDetailsPageUI.NEXT_BUTTON_EACH_CARD_BY_NUMBER_PAGE, "class", "stockquantityhistory", currentNumberPage).contains("disabled")) {
			System.out.println("Next button is not actived.");
			return false;
		}
		else return true;
	} 
	
	public Date convertStringToDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
