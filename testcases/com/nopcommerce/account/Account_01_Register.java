package com.nopcommerce.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Account_01_Register extends BasePage {
	private WebDriver driver;
	private String emailAddress;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Mac")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		}

		driver = new FirefoxDriver();
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void Register_01_Empty() {
		openPageUrl(driver, "http://demo.nopcommerce/");

		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "account.fields.firstname.required");
		Assert.assertEquals(getElementText(driver, "//span[@id= 'LastName-error']"), "account.fields.lastname.required");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "account.fields.email.required");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "account.fields.confirmpassword.required");

	}

	@Test
	public void Register_02_Invalid_Email() {
		openPageUrl(driver, "http://demo.nopcommerce/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Hana");
		sendkeyToElement(driver, "//input[@id='LastName']", "Hasta");
		sendkeyToElement(driver, "//input[@id='Email']", "21334@vn");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "common.wrongemail");

	}

	@Test
	public void Register_03_Successful() {
		openPageUrl(driver, "http://demo.nopcommerce/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Hana");
		sendkeyToElement(driver, "//input[@id='LastName']", "Hasta");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "account.register.result.standard");

		clickToElement(driver, "//a[@class='ico-logout']");
	}

	@Test
	public void Register_04_Existing_Email() {
		openPageUrl(driver, "http://demo.nopcommerce/");

		clickToElement(driver, "//a[@class='ico-register']");
		
		sendkeyToElement(driver, "//input[@id='FirstName']", "Hanna");
		sendkeyToElement(driver, "//input[@id='LastName']", "Manana");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"), "account.register.errors.emailalreadyexists");
		
	}

	@Test
	public void Register_05_Password_Less_Than_6_Characters() {
		openPageUrl(driver, "http://demo.nopcommerce/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Hanna");
		sendkeyToElement(driver, "//input[@id='LastName']", "Manana");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@data-valmsg-for='Password']"), "validation.password.rule");
	}

	@Test
	public void Register_06_Not_Matching_Password() {
		openPageUrl(driver, "http://demo.nopcommerce/");

		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Hanna");
		sendkeyToElement(driver, "//input[@id='LastName']", "Manana");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "1235467");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "account.fields.password.enteredpasswordsdonotmatch");

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
