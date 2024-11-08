package com.nopcommerce.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.user.ChangePasswordPageObject;
import pageObjects.user.CustomerAddressPageObject;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.CustomerProductReviewPageObject;
import pageObjects.user.DetailProductPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.UserLoginPageObject;

public class Account_03_My_Account extends BaseTest {
	private WebDriver driver;
	private String emailAddress = "afc3574@mail.vn";
	private String contentReview = "Good price";
	private String titleReview = "No problem";
	private String ratingReview = "3";
	private HomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private CustomerPageObject customerPage;
	private CustomerAddressPageObject customerAddressPage;
	private ChangePasswordPageObject changePasswordPage;
	private DetailProductPageObject detailProductPage;
	private CustomerProductReviewPageObject customerProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		userLoginPage = homePage.clickToLoginLink();

		userLoginPage.enterToEmailAddress(emailAddress);
		userLoginPage.enterToPassword("Goodmorning11");

		homePage = userLoginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), emailAddress);
	}

	public void My_Account_01_Update_CustomerInfo() {
		customerPage.updateFullInfo("Female", "Automation", "FC", "afc3574@mail.vn", "Automation FC");

		Assert.assertEquals(customerPage.getUpdatedNotificationBarText(),"account.customerinfo.updated");
		Assert.assertTrue(customerPage.verifyCheckedGenderRadiobox("Female"));
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.firstname"), "Automation");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.lastname"), "FC");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), "afc3574@mail.vn");
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.company"), "Automation FC");
	}
	
	public void My_Account_02_Add_Address() {
		customerPage.openDynamicSideBarPage("account.customeraddresses");
		customerAddressPage = PageGeneratorManager.getCustomerAddressObject(driver);
		
		customerAddressPage.openAddressForm();
		customerAddressPage.inputAddressForm("Hutomation", "FC", "vivo.vn@gmail.com", "Automation FC", "Vietnam", "Hải Phòng", "Hải Phòng", "123/04 Lê Lai", "234/05 Hải Phòng", "550000", "0123456789", "0987654321");
		 
		Assert.assertEquals(customerAddressPage.getAddedNotificationBarText(),"account.customeraddresses.added");
		
		String indexOfAddedAddress = String.valueOf(customerAddressPage.numberOfListAddress());
		System.out.println(indexOfAddedAddress);
		Assert.assertEquals(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "name"), "Hutomation FC");
		Assert.assertTrue(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "email").contains("vivo.vn@gmail.com"));
		Assert.assertTrue(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "phone").contains("0123456789"));
		Assert.assertTrue(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "fax").contains("0987654321"));
		Assert.assertEquals(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "company"), "Automation FC");
		Assert.assertEquals(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "country"), "Vietnam");
		Assert.assertEquals(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "address1"), "123/04 Lê Lai");
		Assert.assertEquals(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "address2"), "234/05 Hải Phòng");
		Assert.assertEquals(customerAddressPage.getAddedInfoText(indexOfAddedAddress, "zippostalcode"), "550000");
	}

	
	public void My_Account_03_Change_Password() {
		customerPage.openDynamicSideBarPage("account.changepassword");
		changePasswordPage = PageGeneratorManager.getChangePasswordObject(driver);
		
		changePasswordPage.inputChangePasswordForm("234GogoLove", "Goodmorning11");
		
		Assert.assertEquals(changePasswordPage.getChangePasswordNotificationBarText(), "account.changepassword.success");
		
		homePage = changePasswordPage.logout();
		userLoginPage = homePage.clickToLoginLink();
		
		userLoginPage.enterToLoginForm(emailAddress, "234GogoLove");
		Assert.assertTrue(userLoginPage.getEmailNotExistTextMessage().contains("account.login.unsuccessful\naccount.login.wrongcredentials"));
		
		userLoginPage.enterToLoginForm(emailAddress, "Goodmorning11");
		homePage = PageGeneratorManager.getHomePageObject(driver);
		customerPage = homePage.clickToMyAccountLink();
		Assert.assertEquals(customerPage.getInfoTextboxAttributeValue("account.fields.email"), emailAddress);
	}

	@Test
	public void My_Account_04_Add_Review_Product() {
		customerPage.backToPage(driver);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		detailProductPage = homePage.clickToProduct("MacBook");
		String titleSelectedProduct = detailProductPage.getTitleDetailProduct();
		Assert.assertTrue(detailProductPage.getPageTitle(driver).contains("MacBook"));
		Assert.assertTrue(titleSelectedProduct.contains("MacBook"));
		
		detailProductPage.inputReviewForm(titleReview, contentReview, ratingReview);
//		Assert.assertEquals(detailProductPage.getReviewTextNotificationBar(), "reviews.successfullyadded");
		Assert.assertTrue(detailProductPage.areExpectedTextInInnerText(driver, "reviews.successfullyadded"));
		
		detailProductPage.closeReviewNotiBar();
		customerPage = detailProductPage.clickToMyAccountLink();
		
		customerPage.openDynamicSideBarPage("account.customerproductreviews");
		customerProductReviewPage = PageGeneratorManager.getCustomerProductReviewPageObject(driver);
		
		Assert.assertTrue(customerProductReviewPage.getPageTitleText().contains("account.customerproductreviews"));
		Assert.assertEquals(customerProductReviewPage.getAddedReviewTitleText(), titleReview);
		System.out.println(customerProductReviewPage.getAddedReviewRatingValue());
		Assert.assertEquals(customerProductReviewPage.getAddedReviewRatingValue(), ratingReview);
		Assert.assertEquals(customerProductReviewPage.getAddedContentReviewText(), contentReview);
		Assert.assertEquals(customerProductReviewPage.getAddedProductReviewText(), titleSelectedProduct);
		
	}

	@AfterClass
	public void afterClass() {

	}

}
