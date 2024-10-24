package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;*/

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
//	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver;

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


}
