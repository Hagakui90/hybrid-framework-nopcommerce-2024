package pageObjects.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
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
	
	public List<Date>getDetailsItemByCardNameAndValueName(String cardName, String valueName) {
		List<WebElement> listDetailsItemByCardName = getListWebElement(driver, AdminEditProductDetailsPageUI.ALL_VALUES_COLUMN_INDEX, AdminEditProductDetailsPageUI.COLUMN_INDEX_BY_COLUMN_NAME, cardName, valueName) ;
		List<Date> detailsItemByValueName = new ArrayList<Date>();
		for (WebElement detailsItemString : listDetailsItemByCardName) {
			detailsItemByValueName.add(convertStringToDate(detailsItemString.getText()));
		}
		return detailsItemByValueName;
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
