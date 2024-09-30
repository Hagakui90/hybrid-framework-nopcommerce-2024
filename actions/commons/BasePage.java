package commons;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	/* Web Browser */
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();		
	}
	
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getTextInAlert(WebDriver driver) {
		waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String keysToSend) {
		waitForAlertPresence(driver).sendKeys(keysToSend);
	}
	
	public void switchToWindowById(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
				
			}
		}
	}
	
	public void switchToWindowByName(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			
			String currentlyPageTitle = driver.getCurrentUrl();
			if (currentlyPageTitle.equals(expectedPageTitle)) {
				break;
				
			}
		}
	}
	
	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
				
			}
			driver.switchTo().window(parentID);
			
		}
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond *1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
