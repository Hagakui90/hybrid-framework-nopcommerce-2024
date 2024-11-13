package com.nopcommerce.view;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.guest.ComputersCategoryPageObject;
import pageObjects.guest.NotebooksSubPageObject;
import pageObjects.user.HomePageObject;

public class View_02_Sort_Display_Paging extends BaseTest{
	private WebDriver driver;
	private HomePageObject homePage;
	private ComputersCategoryPageObject computersPage;
	private NotebooksSubPageObject notebooksSubPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass (String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		homePage.openHomeHeaderMenuPage("Computers");
		computersPage = PageGeneratorManager.getComputersPageObject(driver);
		Assert.assertEquals(computersPage.getPageTitle(), "Computers");
		
		computersPage.openCategoriesSideBarPage("Computers", "Notebooks");
		notebooksSubPage = PageGeneratorManager.getNotebooksSubPage(driver);
		Assert.assertEquals(notebooksSubPage.getPageTitle(), "Notebooks");
	}

	@Test
	public void Sort_01_Name_A_To_Z() {
		Assert.assertTrue(notebooksSubPage.verifySortNameAscending());
	}

	@Test
	public void Sort_02_Name_Z_To_A() {
		Assert.assertTrue(notebooksSubPage.verifySortNameDescending());
	}

	@Test
	public void Sort_03_Price_Low_To_High() {

	}

	@Test
	public void Sort_04_Price_High_To_Low() {

	}

	@Test
	public void Display_05_3_Products_Per_Page() {

	}

	@Test
	public void Display_06_6_Products_Per_Page() {

	}

	@Test
	public void Display_07_9_Products_Per_Page() {

	}

	@AfterClass
	public void afterClass() {

	}

}
