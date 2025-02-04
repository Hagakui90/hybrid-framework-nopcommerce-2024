package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;*/
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
//	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	protected final Logger log;
	
	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		if (browser == BrowserList.FIREFOX) {
			//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = WebDriverManager.firefoxdriver().create();
			//driver = new FirefoxDriver();
		} else if (browser == BrowserList.CHROME) {
			//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			driver = WebDriverManager.chromedriver().create();
		} else if (browser == BrowserList.EDGE) {
			//System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			//driver = new EdgeDriver();
			driver = WebDriverManager.edgedriver().create();

		} else {
			throw new RuntimeException("Browser name is not valid");
		}
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://demo.nopcommerce/");
		return driver;
	}
	
	
	protected WebDriver getBrowserDriver(String browserName, String userUrl) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		
		if (browser == BrowserList.FIREFOX) {
			//System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = WebDriverManager.firefoxdriver().create();
			//driver = new FirefoxDriver();
		} else if (browser == BrowserList.CHROME) {
			//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			//driver = new ChromeDriver();
			driver = WebDriverManager.chromedriver().create();
		} else if (browser == BrowserList.EDGE) {
			//System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			//driver = new EdgeDriver();
			driver = WebDriverManager.edgedriver().create();

		} else {
			throw new RuntimeException("Browser name is not valid");
		}
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get(userUrl);
		return driver;
	}

	protected int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	 
	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("-----------------------------PASS-------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("-----------------------------FAIL-------------------");
		}
		return status;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("-----------------------------PASS-------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("-----------------------------FAIL-------------------");
		}
		return status;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean status = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info("-----------------------------PASS-------------------");
		} catch (Throwable e) {
			status = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
			log.info("-----------------------------FAIL-------------------");
		}
		return status;
	}

}
